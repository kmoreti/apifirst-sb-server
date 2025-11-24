package com.moreti.apifirstserver.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;
import java.util.UUID;

@AllArgsConstructor
@Getter
@Setter
@Builder
public class PaymentMethod {
    private UUID id;
    private String displayName;
    private Integer cardNumber;
    private Integer expiryMonth;
    private Integer expiryYear;
    private Integer cvv;
    private OffsetDateTime dateCreated;
    private OffsetDateTime dateUpdated;
}
