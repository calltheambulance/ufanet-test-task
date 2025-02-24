package ru.stc.dantes.clientapi.dto;

import lombok.Getter;
/*
 * Класс для вывода Клиента только с полями id, name
 */

@Getter
public class ClientDto {
    private int id;
    private String name;

    // Конструктор
    public ClientDto(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
