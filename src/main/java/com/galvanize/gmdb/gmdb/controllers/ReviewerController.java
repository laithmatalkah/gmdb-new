package com.galvanize.gmdb.gmdb.controllers;

import com.galvanize.gmdb.gmdb.service.ReviewerService;
import org.springframework.stereotype.Controller;

@Controller
public class ReviewerController {

    private final ReviewerService reviewerService;

    public ReviewerController(ReviewerService reviewerService) {
        this.reviewerService = reviewerService;
    }


}
