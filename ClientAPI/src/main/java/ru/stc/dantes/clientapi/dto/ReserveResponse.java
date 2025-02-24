package ru.stc.dantes.clientapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/*
 *  Класс, который отправляет id заказа в ответ на запрос об оформлении брони
 */

@Data
@AllArgsConstructor
public class ReserveResponse {
    private int orderId;
}
