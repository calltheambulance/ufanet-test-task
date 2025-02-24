package ru.stc.dantes.clientapi.dto;


import jakarta.validation.constraints.NotNull;
import lombok.Data;

/*
 * Класс, который хранит информацию от пользователя при оформлении брони
 */

@Data
public class ReserveRequest {

    @NotNull(message = "Поле 'date' не может быть null")
    private String date;

    @NotNull(message = "Поле 'time' не может быть null")
    private String time;

    @NotNull(message = "Поле 'clientId' не может быть null")
    private int clientId;
}
