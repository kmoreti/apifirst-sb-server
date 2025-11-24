package com.moreti.apifirstserver.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@AllArgsConstructor
@Getter
@Setter
@Builder
public class OrderCustomer {
    private UUID id;
    private Name name;
    private Address shipToAddress;
    private Address billToAddress;
    private String email;
    private String phone;
    private PaymentMethod selectedPaymentMethod;
}
