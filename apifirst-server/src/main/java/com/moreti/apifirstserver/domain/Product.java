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
public class Product {
    private UUID id;
    private String description;
    private Dimensions dimensions;
    @Builder.Default
    private List<Category> categories = new ArrayList<>();
    @Builder.Default
    private List<Image> images = new ArrayList<>();
    private String price;
    private String cost;
    private OffsetDateTime dateCreated;
    private OffsetDateTime dateUpdated;
}
