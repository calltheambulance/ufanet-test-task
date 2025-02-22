package ru.stc.dantes.clientapi.dto;

/*
    Класс для добавления нового клиента
 */

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class ClientRequest {


    @Pattern(
            regexp = "^[A-Za-zА-Яа-я\\s]+$",
            message = "ФИО должно содержать только буквы и пробелы"
    )
    @Size(min = 2, max = 100, message = "ФИО должно быть от 2 до 100 символов")
    private String name;

    @Pattern(
            regexp = "^((\\+7|8)[\\s-]?)?(\\(?\\d{3}\\)?[\\s-]?)?[\\d\\s-]{7,10}$",
            message = "Номер телефона должен быть в формате +7XXXXXXXXXX или 8XXXXXXXXXX"
    )
    private String phone;

    @Email(message = "Email введён некорректно")
    private String email;
}
