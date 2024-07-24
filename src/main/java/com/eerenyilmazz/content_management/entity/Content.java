package com.eerenyilmazz.content_management.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
public class Content {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String plot;
    private String poster;
    private Integer year;
    private String language;
    private String country;

    @ManyToOne
    @JoinColumn(name = "metadata_id")
    private Metadata metadata;

    @OneToMany(mappedBy = "content")
    private List<Cast> cast;

    private LocalDateTime createdAt;
}
