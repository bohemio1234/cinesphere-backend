package com.bohemio.cinespherebackend.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long movieId;
    private String author;
    private Double rating;

    @Column(columnDefinition = "TEXT")
    private String content;

}
