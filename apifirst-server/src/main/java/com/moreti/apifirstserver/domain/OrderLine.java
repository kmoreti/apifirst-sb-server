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
public class OrderLine {
    private UUID id;
    private OrderProduct product;
    private Integer orderQuantity;
    private Integer shipQuantity;
    private OffsetDateTime dateCreated;
    private OffsetDateTime dateUpdated;
}
