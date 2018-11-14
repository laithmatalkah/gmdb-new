package com.galvanize.gmdb.gmdb.controllers;

import com.galvanize.gmdb.gmdb.model.Reviewer;
import com.galvanize.gmdb.gmdb.service.ReviewerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ReviewerController {

    private final ReviewerService reviewerService;

    public ReviewerController(ReviewerService reviewerService) {
        this.reviewerService = reviewerService;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/add")
    public void addReviewer(Reviewer reviewer) {
        this.reviewerService.addReviewer(reviewer);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public Reviewer getReviewer(@PathVariable("id") Long id) {
        return this.reviewerService.getReviewer(id);

    }

    @RequestMapping(method = RequestMethod.PUT, value = "/update")
    public void updateReviewer(Reviewer reviewer) {
        this.reviewerService.updateReviewer(reviewer);
    }


}
