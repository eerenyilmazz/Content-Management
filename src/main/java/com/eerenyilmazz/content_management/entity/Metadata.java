package com.eerenyilmazz.content_management.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Metadata {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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