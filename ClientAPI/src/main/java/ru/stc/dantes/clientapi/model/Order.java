package ru.stc.dantes.clientapi.model;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

/*
    Поля класса:
    id ID
    date DATE
    time VARCHAR(в формате 10:00 11:00 итд)
    clientId ID(из таблицы клиентов)

 */
@Data
@Builder
public class Order {

    private int id;

    private String time;

    private LocalDate date;

    private int clientId;
}
