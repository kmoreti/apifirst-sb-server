package com.moreti.apifirstserver.domain;

import lombok.*;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Getter
@Setter
@Builder
public class Customer {
    private UUID id;
    private Name name;
    private Address shipToAddress;
    private Address billToAddress;
    private String email;
    private String phone;
    @Builder.Default
    private List<PaymentMethod> paymentMethods = new ArrayList<>();
    private OffsetDateTime dateCreated;
    private OffsetDateTime dateUpdated;
}
