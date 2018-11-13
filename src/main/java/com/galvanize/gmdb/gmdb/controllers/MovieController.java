package com.galvanize.gmdb.gmdb.controllers;

import com.galvanize.gmdb.gmdb.model.Movie;
import com.galvanize.gmdb.gmdb.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class MovieController {

    private final MovieService movieService;


    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    public List<Movie> getMovies() {

        List<Movie> movies = this.movieService.getMovies();


        return movies;
    }

    public Movie getMovie(Long id) {

        Movie movie = this.movieService.getMovie(id);

        return movie;

    }

    public void addMovie(Movie movie) {
        this.movieService.addMovie(movie);
    }

    public void deleteMovie(Long id) {
        this.movieService.deleteMovie(id);
    }

    public void updateMovie(Movie movie) {
        this.movieService.updateMovie(movie);
    }


}
