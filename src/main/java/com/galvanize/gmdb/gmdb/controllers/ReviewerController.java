package com.galvanize.gmdb.gmdb.controllers;

import com.galvanize.gmdb.gmdb.model.Reviewer;
import com.galvanize.gmdb.gmdb.service.ReviewerService;
import org.springframework.stereotype.Controller;

@Controller
public class ReviewerController {

    private final ReviewerService reviewerService;

    public ReviewerController(ReviewerService reviewerService) {
        this.reviewerService = reviewerService;
    }


    public void addReviewer(Reviewer reviewer) {
        this.reviewerService.addReviewer(reviewer);
    }

    public Reviewer getReviewer(Long id) {
        return this.reviewerService.getReviewer(id);

    }

    public void updateReviewer(Reviewer reviewer) {
        this.reviewerService.updateReviewer(reviewer);
    }


}
