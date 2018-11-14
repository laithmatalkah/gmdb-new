package com.galvanize.gmdb.gmdb.controllers;

import com.galvanize.gmdb.gmdb.model.Reviewer;
import com.galvanize.gmdb.gmdb.service.ReviewerService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ReviewerControllerTests {

    ReviewerService reviewerServiceMock;
    Reviewer reviewer;

    @Before
    public void setUp() throws Exception {

        reviewerServiceMock = Mockito.mock(ReviewerService.class);

        reviewer = new Reviewer(1L, "reviewerName1", new Date(), null);

    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testAddReviewer() {

        ReviewerController reviewerController = new ReviewerController(reviewerServiceMock);

        reviewerController.addReviewer(this.reviewer);

        // verify(dependency, times(1)).yourMethod()
        verify(reviewerServiceMock, times(1)).addReviewer(this.reviewer);

    }

    @Test
    public void testGetReviewer() {

        ReviewerController reviewerController = new ReviewerController(reviewerServiceMock);
        reviewerController.getReviewer(1L);

        when(reviewerServiceMock.getReviewer(1L)).thenReturn(reviewer);

        //exercise
        Reviewer actual = reviewerController.getReviewer(1L);

        //assert
        assertEquals(actual, reviewer);

    }

    @Test
    public void testUpdateReviewer() {

        ReviewerController reviewerController = new ReviewerController(reviewerServiceMock);
        reviewerController.updateReviewer(reviewer);

        verify(reviewerServiceMock, times(1)).updateReviewer(this.reviewer);

    }
}