package com.galvanize.gmdb.gmdb.controllers;


import com.galvanize.gmdb.gmdb.model.Review;
import com.galvanize.gmdb.gmdb.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class ReviewController {

    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }


    public void addReview(Review review) {
        this.reviewService.addReview(review);
    }

    public void updateReview(Review review) {
        this.reviewService.updateReview(review);
    }

    public void deleteReview(Review review) {
        this.reviewService.deleteReview(review);
    }
}
