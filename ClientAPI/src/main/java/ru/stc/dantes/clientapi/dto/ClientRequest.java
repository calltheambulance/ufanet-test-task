package ru.stc.dantes.clientapi.dto;

/*
    Класс для добавления нового клиента
 */

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ClientRequest {
    private String name;
    private String phone;
    private String email;
}
