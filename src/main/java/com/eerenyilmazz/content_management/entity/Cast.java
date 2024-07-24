package com.eerenyilmazz.content_management.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Cast {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String poster;

    @ManyToOne
    @JoinColumn(name = "content_id")
    private Content content;
}
