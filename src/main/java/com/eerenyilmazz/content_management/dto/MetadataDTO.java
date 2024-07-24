package com.eerenyilmazz.content_management.dto;

import lombok.Data;

@Data
public class MetadataDTO {
    private Long id;
    private String title;
    private String plot;
    private String poster;
    private Integer year;
    private String language;
    private String country;
    private String imdbId;
    private String imdbRating;
}