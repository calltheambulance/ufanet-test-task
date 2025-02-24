package ru.stc.dantes.clientapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/*
    Класс, который хранит информацию о свободных местах на указанное время
 */

@Data
@AllArgsConstructor
public class AvailableSlotResponse {

    private String time;

    private int count;
}
