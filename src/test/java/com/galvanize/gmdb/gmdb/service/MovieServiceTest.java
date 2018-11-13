package com.galvanize.gmdb.gmdb.service;

import com.galvanize.gmdb.gmdb.model.Movie;
import com.galvanize.gmdb.gmdb.repository.MovieRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

public class MovieServiceTest {

    MovieRepository movieRepository;
    Movie movie;

    @Before
    public void setUp() throws Exception {
        movieRepository = Mockito.mock(MovieRepository.class);
        movie= new Movie(1L,"Test Title1","1986","Test Genre1", 2L, null);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getMovies() {
    }

    @Test
    @Ignore
    public void getMovie() {

        MovieService movieService = new MovieService(this.movieRepository);

        when(this.movieRepository.findById(1L).get()).thenReturn(this.movie);

        Movie actual = movieService.getMovie(1L);

        assertEquals(this.movie, actual);
    }

    @Test
    public void addMovie() {
    }

    @Test
    public void updateMovie() {
    }

    @Test
    public void deleteMovie() {
    }
}