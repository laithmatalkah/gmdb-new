package com.galvanize.gmdb.gmdb.controllers;


import com.galvanize.gmdb.gmdb.model.Review;
import com.galvanize.gmdb.gmdb.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/review")
public class ReviewController {

    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @RequestMapping(method = RequestMethod.POST,value = "/add")
    public void addReview(@RequestBody Review review) {
        this.reviewService.addReview(review);
    }
    @RequestMapping(method = RequestMethod.PUT,value = "/update")
    public void updateReview(Review review) {
        this.reviewService.updateReview(review);
    }
    @RequestMapping(method =RequestMethod.DELETE,value = "/delete/{id}")
    public void deleteReview(@PathVariable ("id") Long id) {
        this.reviewService.deleteReview(id);
    }
}
