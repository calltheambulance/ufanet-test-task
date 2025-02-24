package ru.stc.dantes.clientapi.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 * Класс-сущность для Клиента
 */

@Data
@Builder
@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true, nullable = false, name = "client_name")
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
    @Column(unique = true, nullable = false, name = "client_phone")
    private String phone;


    @Email(message = "Email введён некорректно")
    @Column(unique = true, nullable = false, name = "client_email")
    private String email;


}
