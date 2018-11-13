package com.galvanize.gmdb.gmdb.controllers;

import com.galvanize.gmdb.gmdb.model.Review;
import com.galvanize.gmdb.gmdb.model.Reviewer;
import com.galvanize.gmdb.gmdb.service.ReviewService;
import org.junit.After;
import org.junit.Before;

import static org.junit.Assert.*;
import com.galvanize.gmdb.gmdb.controllers.MovieController;
import com.galvanize.gmdb.gmdb.model.Movie;
import com.galvanize.gmdb.gmdb.service.MovieService;
import org.hamcrest.collection.IsIterableContainingInOrder;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ReviewControllerTests {

    ReviewService reviewServiceMock;
    Review review;

    @Before
    public void setUp() throws Exception {
        reviewServiceMock = Mockito.mock(ReviewService.class);
        Movie movie= new Movie(1L,"Test Title1","1986","Test Genre1", 2L, null);
        Reviewer reviewer = new Reviewer(1L, "reviewerName1", new Date(), null);
        review = new Review(1,"Blah",1L,1L,new Date(), movie, reviewer);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testPostReview() {
        ReviewController reviewController = new ReviewController(this.reviewServiceMock);

        reviewController.addReview(this.review);

        // verify(dependency, times(1)).yourMethod()
        verify(this.reviewServiceMock, times(1)).addReview(this.review);
    }

    @Test
    public void testUpdateReview() {

        ReviewController reviewController = new ReviewController(this.reviewServiceMock);

        reviewController.updateReview(this.review);

        // verify(dependency, times(1)).yourMethod()
        verify(this.reviewServiceMock, times(1)).updateReview(this.review);

    }

    @Test
    public void testDeleteReview() {

        ReviewController reviewController = new ReviewController(this.reviewServiceMock);

        reviewController.deleteReview(this.review);

        // verify(dependency, times(1)).yourMethod()
        verify(this.reviewServiceMock, times(1)).deleteReview(this.review);


    }

}