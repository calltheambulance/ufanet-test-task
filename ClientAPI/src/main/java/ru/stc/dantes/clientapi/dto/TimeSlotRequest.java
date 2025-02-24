package ru.stc.dantes.clientapi.dto;

import lombok.Data;

/*
    Класс для создания пользователем временного слота
 */

@Data
public class TimeSlotRequest {
    private String date;
    private String time;
    private int maxClients;

}
