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
public class Image {
    private UUID id;
    private String url;
    private String altText;
    private OffsetDateTime dateCreated;
    private OffsetDateTime dateUpdated;
}
