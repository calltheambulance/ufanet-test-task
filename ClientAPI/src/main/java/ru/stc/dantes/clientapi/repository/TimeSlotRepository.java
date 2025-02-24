package ru.stc.dantes.clientapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.stc.dantes.clientapi.model.TimeSlot;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface TimeSlotRepository extends JpaRepository<TimeSlot, Integer> {
    List<TimeSlot> findByDate(LocalDate date);

    Optional<TimeSlot> findByDateAndTime(LocalDate date, LocalTime time);

}
