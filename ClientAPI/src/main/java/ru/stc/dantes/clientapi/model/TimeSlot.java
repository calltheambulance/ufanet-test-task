package ru.stc.dantes.clientapi.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;
/*
 * Класс-сущность для временных слотов
 */

@Getter
@Setter
@Entity
@Table(name = "timeslot")
@NoArgsConstructor
public class TimeSlot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "time_slot_id")
    private int id;

    @Column(nullable = false, name = "timeslot_date")
    private LocalDate date;

    @Column(nullable = false, name = "timeslot_time")
    private LocalTime time;

    @Column(name = "timeslot_max_clients")
    private int maxClients;

    @Column(name = "timeslot_available_slots")
    private int availableSlots;

    public TimeSlot(LocalDate date, LocalTime time, int maxClients) {
        this.date = date;
        this.time = time;
        this.maxClients = maxClients;
        this.availableSlots = maxClients;
    }
}
