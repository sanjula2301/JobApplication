package com.Adzer.Green.Soloution.review.impl;

import com.Adzer.Green.Soloution.review.Review;

import java.util.List;
import java.util.Optional;

public interface ReviewService {
    List<Review> getAllReviews(Long companyId);
    Review createReview(Long companyId, Review review);
    Optional<Review> getReviewById(Long companyId, Long reviewId);
    Review updateReview(Long companyId, Long reviewId, Review reviewDetails);
    boolean deleteReview(Long companyId, Long reviewId);
}
