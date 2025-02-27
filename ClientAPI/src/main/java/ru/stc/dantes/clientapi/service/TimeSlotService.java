package ru.stc.dantes.clientapi.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.stc.dantes.clientapi.dto.*;
import ru.stc.dantes.clientapi.exception.OrderException;
import ru.stc.dantes.clientapi.model.Client;
import ru.stc.dantes.clientapi.model.Order;
import ru.stc.dantes.clientapi.model.TimeSlot;
import ru.stc.dantes.clientapi.repository.ClientRepository;
import ru.stc.dantes.clientapi.repository.OrderRepository;
import ru.stc.dantes.clientapi.repository.TimeSlotRepository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

/*
 * Сервис с бизнес-логикой по бронированию и временным слотам
 */

@Service
@Slf4j
@RequiredArgsConstructor
public class TimeSlotService {
    private final TimeSlotRepository timeSlotRepository;
    private final ClientRepository clientRepository;
    private final OrderRepository orderRepository;

    /*
     * Функция для получения свободных слотов по указанной дате
     */
    public List<AvailableSlotResponse> getAvailableSlots(LocalDate date) {
        return timeSlotRepository.findByDate(date).stream()
                .filter(slot -> slot.getAvailableSlots() > 0)
                .map(slot -> new AvailableSlotResponse(
                        slot.getTime().toString(),
                        slot.getAvailableSlots()
                ))
                .collect(Collectors.toList());
    }

    /*
     *  Функция для оформления брони
     */

    public ReserveResponse reserveSlot(ReserveRequest request) {
        LocalTime time = LocalTime.parse(request.getTime());

        if (time.getMinute() != 0 || time.getSecond() != 0) {
            throw new IllegalArgumentException("Неккоректный формат времени. Верный формат: 11:00");

        }
        if (time.getHour() < 9 || time.getHour() >= 23) {
            throw new IllegalArgumentException("Бассейн работает с 9:00 до 23:00");
        }

        Client client = clientRepository.findById(request.getClientId()).orElseThrow(() -> new RuntimeException("Клиент не найден"));

        TimeSlot timeSlot = timeSlotRepository.findByDateAndTime(
                LocalDate.parse(request.getDate()),
                time
        ).orElseThrow(() -> new OrderException("Слот не найден"));

        if (orderRepository.existsByClientAndTimeSlot(client, timeSlot)) {
            throw new OrderException("Вы уже забронировали этот слот");
        }

        if (orderRepository.countByTimeSlot(timeSlot) >= timeSlot.getMaxClients()) {
            throw new OrderException("Нет свободных мест");
        }

        Order order = Order.builder()
                .client(client)
                .timeSlot(timeSlot)
                .build();
        orderRepository.save(order);

        timeSlot.setAvailableSlots(timeSlot.getAvailableSlots() - 1);
        timeSlotRepository.save(timeSlot);

        return new ReserveResponse(order.getId());
    }

    /*
     *  Функция для создания свободных слотов
     */

    public void createTimeSlot(TimeSlotRequest request) {
        TimeSlot timeSlot = new TimeSlot(
                LocalDate.parse(request.getDate()),
                LocalTime.parse(request.getTime()),
                request.getMaxClients()
        );
        timeSlotRepository.save(timeSlot);
    }

    public void cancelReservation(CancelRequest request) {

        Order order = orderRepository.findById(request.getOrderId())
                .orElseThrow(() -> new RuntimeException("Запись не найдена"));

        if (order.getClient().getId() != request.getClientId()) {
            throw new RuntimeException("Запись не принадлежит указанному клиенту");
        }

        TimeSlot timeSlot = order.getTimeSlot();
        timeSlot.setAvailableSlots(timeSlot.getAvailableSlots() + 1);
        timeSlotRepository.save(timeSlot);
        orderRepository.delete(order);
    }
}
