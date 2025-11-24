package com.moreti.apifirstserver.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Getter
@Setter
@Builder
public class Order {
    private UUID id;
    private OrderCustomer customer;
    private OrderStatusEnum orderStatus;
    private String shipmentInfo;
    @Builder.Default
    private List<OrderLine> orderLines = new ArrayList<>();
    private OffsetDateTime dateCreated;
    private OffsetDateTime dateUpdated;
}
