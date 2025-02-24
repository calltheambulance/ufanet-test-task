package ru.stc.dantes.clientapi.exception;

/*
    Кастомное исключение для ошибок, связанных с неверной работой с оформлением брони. Например: Слот не найден, Слот уже забронирован
 */
public class OrderException extends RuntimeException {
    public OrderException(String message) {
        super(message);
    }
}
