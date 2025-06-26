package com.bohemio.cinespherebackend.service;

import com.bohemio.cinespherebackend.domain.Review;
import com.bohemio.cinespherebackend.dto.ReviewDto;
import com.bohemio.cinespherebackend.repository.ReviewRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ReviewServiceImplTest {

    @Mock // 가짜 ReviewRepository 생성
    private ReviewRepository reviewRepository;

    @InjectMocks // 가짜 Repository를 실제 Service에 주입
    private ReviewServiceImpl reviewService;

    @Test
    @DisplayName("리뷰 생성 성공 테스트")
    void createReview_Success(){
        ReviewDto reviewDto = new ReviewDto();
        reviewDto.setMovieId(1L);
        reviewDto.setAuthor("Bohemio");
        reviewDto.setRating(5.0);
        reviewDto.setContent("정말 재미있는 영화!");

        Review savedReview = new Review();
        savedReview.setId(1L);
        savedReview.setMovieId(reviewDto.getMovieId());
        savedReview.setAuthor(reviewDto.getAuthor());
        savedReview.setRating(reviewDto.getRating());
        savedReview.setContent(reviewDto.getContent());



        when(reviewRepository.save(any(Review.class))).thenReturn(savedReview);

        ReviewDto createdReviewDto = reviewService.createReview(reviewDto);

        assertThat(createdReviewDto).isNotNull();
        assertThat(createdReviewDto.getId()).isEqualTo(1L); // ID가 정상적으로 부여되었는지
        assertThat(createdReviewDto.getAuthor()).isEqualTo("Bohemio");
        assertThat(createdReviewDto.getContent()).isEqualTo("정말 재미있는 영화!");


    }

}
