package com.bohemio.cinespherebackend.service;

import com.bohemio.cinespherebackend.domain.Review;
import com.bohemio.cinespherebackend.dto.ReviewDto;
import com.bohemio.cinespherebackend.repository.ReviewRepository;
import org.springframework.stereotype.Service;

@Service
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;

    public ReviewServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public ReviewDto createReview(ReviewDto reviewDto) {
        //종이받으면
        Review reviewEntity = new Review();

        //그거확인해서 채워주고
        reviewEntity.setMovieId(reviewDto.getMovieId());
        reviewEntity.setAuthor(reviewDto.getAuthor());
        reviewEntity.setRating(reviewDto.getRating());
        reviewEntity.setContent(reviewDto.getContent());

        //전산에,db에 넣고 (save)
        Review savedEntity = reviewRepository.save(reviewEntity);

        //저장된 entityf를 다시 dto로 변환해 controller에게 줌.
        ReviewDto resultDto = new ReviewDto();

        resultDto.setId(savedEntity.getId());
        resultDto.setMovieId(savedEntity.getMovieId());
        resultDto.setAuthor(savedEntity.getAuthor());
        resultDto.setRating(savedEntity.getRating());
        resultDto.setContent(savedEntity.getContent());

        return resultDto;

    }

}
