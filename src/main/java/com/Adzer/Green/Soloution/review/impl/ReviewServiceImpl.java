package com.Adzer.Green.Soloution.review.impl;

import com.Adzer.Green.Soloution.company.Company;
import com.Adzer.Green.Soloution.company.CompanyRepository;
import com.Adzer.Green.Soloution.review.Review;
import com.Adzer.Green.Soloution.review.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewServiceImpl implements ReviewService{
    private final ReviewRepository reviewRepository;
    private final CompanyRepository companyRepository;

    public ReviewServiceImpl(ReviewRepository reviewRepository, CompanyRepository companyRepository) {
        this.reviewRepository = reviewRepository;
        this.companyRepository = companyRepository;
    }

    @Override
    public List<Review> getAllReviews(Long companyId) {
        return reviewRepository.findByCompanyCompanyId(companyId);
    }

    @Override
    public Review createReview(Long companyId, Review review) {
        Optional<Company> company = companyRepository.findById(companyId);
        if (company.isEmpty()) {
            return null;
        }
        review.setCompany(company.get());
        return reviewRepository.save(review);
    }

    @Override
    public Optional<Review> getReviewById(Long companyId, Long reviewId) {
        return reviewRepository.findById(reviewId)
                .filter(review -> review.getCompany().getCompanyId().equals(companyId));
    }

    @Override
    public Review updateReview(Long companyId, Long reviewId, Review reviewDetails) {
        return getReviewById(companyId, reviewId).map(existingReview -> {
            existingReview.setTitle(reviewDetails.getTitle());
            existingReview.setDescription(reviewDetails.getDescription());
            existingReview.setRating(reviewDetails.getRating());
            return reviewRepository.save(existingReview);
        }).orElse(null);
    }

    @Override
    public boolean deleteReview(Long companyId, Long reviewId) {
        Optional<Review> review = getReviewById(companyId, reviewId);
        if (review.isEmpty()) {
            return false;
        }
        reviewRepository.delete(review.get());
        return true;
    }
}
