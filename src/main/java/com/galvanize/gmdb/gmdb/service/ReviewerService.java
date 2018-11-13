package com.galvanize.gmdb.gmdb.service;

import com.galvanize.gmdb.gmdb.model.Movie;
import com.galvanize.gmdb.gmdb.model.Reviewer;
import com.galvanize.gmdb.gmdb.repository.ReviewerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewerService {

    private final ReviewerRepository reviewerRepository;

    public ReviewerService(ReviewerRepository reviewerRepository) {
        this.reviewerRepository = reviewerRepository;
    }

    public List<Reviewer> getReviewers() {
        return (List) reviewerRepository.findAll();
    }

    public Reviewer getReviewer(Long id) {
        return reviewerRepository.findById(id).get();
    }

    public void addReviewer(Reviewer reviewer) {
        this.reviewerRepository.save(reviewer);
    }

    public void updateReviewer(Reviewer reviewer) {
        this.reviewerRepository.save(reviewer);
    }
}
