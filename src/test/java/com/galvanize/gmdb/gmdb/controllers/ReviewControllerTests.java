package com.galvanize.gmdb.gmdb.controllers;

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

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }


}