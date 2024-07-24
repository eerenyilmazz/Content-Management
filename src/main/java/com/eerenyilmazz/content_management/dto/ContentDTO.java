package com.eerenyilmazz.content_management.dto;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class ContentDTO {
    private Long id;
    private String title;
    private String plot;
    private String poster;
    private Integer year;
    private String language;
    private String country;
    private List<CastDTO> cast;
    private Long metadataId;
    private LocalDateTime createdAt;
}
