package com.bohemio.cinespherebackend.service;

import com.bohemio.cinespherebackend.dto.ReviewDto;

public interface ReviewService {
    ReviewDto createReview(ReviewDto reviewDto);
}
