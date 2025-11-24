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
public class Category {
    private UUID id;
    private String category;
    private String description;
    private OffsetDateTime dateCreated;
    private OffsetDateTime dateUpdated;
}
