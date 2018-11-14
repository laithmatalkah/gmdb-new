package com.galvanize.gmdb.gmdb.service;

import com.galvanize.gmdb.gmdb.model.Review;
import com.galvanize.gmdb.gmdb.repository.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {

    private final ReviewRepository reviewRepository;

    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public List<Review> getReviews() {
        return (List) reviewRepository.findAll();
    }

    public Review getReview(Long id) {
        return reviewRepository.findById(id).get();
    }

    public void addReview(Review review) {
        this.reviewRepository.save(review);
    }

    public void updateReview(Review review) {
        this.reviewRepository.save(review);
    }

    public void deleteReview(Long id) {
        this.reviewRepository.deleteById(id);
    }
}
