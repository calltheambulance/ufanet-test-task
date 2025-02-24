package ru.stc.dantes.clientapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.stc.dantes.clientapi.model.Client;
import ru.stc.dantes.clientapi.model.Order;
import ru.stc.dantes.clientapi.model.TimeSlot;

import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
    int countByTimeSlot(TimeSlot timeSlot);
    boolean existsByClientAndTimeSlot(Client client, TimeSlot timeSlot);

}
