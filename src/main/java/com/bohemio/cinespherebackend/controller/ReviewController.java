package com.bohemio.cinespherebackend.controller;

import com.bohemio.cinespherebackend.dto.ReviewDto;
import com.bohemio.cinespherebackend.service.ReviewService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {

    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @PostMapping
    public ResponseEntity<ReviewDto> createReview(@RequestBody ReviewDto reviewDto) {
        ReviewDto savedReviewDto = reviewService.createReview(reviewDto);
        return ResponseEntity.status( HttpStatus.CREATED ).body(savedReviewDto);
    }
}
