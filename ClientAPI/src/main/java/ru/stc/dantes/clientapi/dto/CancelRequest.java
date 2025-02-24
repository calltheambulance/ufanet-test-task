package ru.stc.dantes.clientapi.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CancelRequest {

    private int clientId;
    private int orderId;

}
