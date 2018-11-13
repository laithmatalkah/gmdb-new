package com.galvanize.gmdb.gmdb;

import com.galvanize.gmdb.gmdb.model.Movie;
import com.galvanize.gmdb.gmdb.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class MovieController {

    private final MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    public List<Movie> getMovies() {

        List<Movie> movies = this.movieService.getMovies();


        return movies;
    }
}
