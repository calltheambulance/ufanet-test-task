package ru.stc.dantes.clientapi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


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
    private String name;

    @Column(unique = true, nullable = false, name = "client_phone")
    private String phone;

    @Column(unique = true, nullable = false, name = "client_email")
    private String email;
}
