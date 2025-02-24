package ru.stc.dantes.clientapi.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.stc.dantes.clientapi.dto.*;
import ru.stc.dantes.clientapi.service.TimeSlotService;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/v0/pool/timetable")
@RequiredArgsConstructor
public class TimetableController {

    private final TimeSlotService timeSlotService;

    @GetMapping("/available")
    public List<AvailableSlotResponse> available(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        return timeSlotService.getAvailableSlots(date);
    }

    @PostMapping("/reserve")
    public ReserveResponse reserve(@Valid @RequestBody ReserveRequest request) {
        return timeSlotService.reserveSlot(request);
    }


    @PostMapping("/timeslot")
    public ResponseEntity<String> createTimeSlot(@RequestBody TimeSlotRequest request) {
        timeSlotService.createTimeSlot(request);
        return ResponseEntity.ok("Временной слот создан");
    }

    @PostMapping("/cancel")
    public ResponseEntity<String> cancelReservation(@RequestBody CancelRequest request) {
        timeSlotService.cancelReservation(request);
        return ResponseEntity.ok("Запись успешно отменена");
    }
}
