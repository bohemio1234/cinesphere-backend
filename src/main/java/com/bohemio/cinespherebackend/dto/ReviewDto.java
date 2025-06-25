package com.bohemio.cinespherebackend.dto;

import lombok.Data;

@Data
public class ReviewDto {

    private Long id;
    private Long movieId;
    private String author;
    private Double rating;
    private String content;

}
