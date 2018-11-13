package com.galvanize.gmdb.gmdb.controllers;

import com.galvanize.gmdb.gmdb.model.Movie;
import com.galvanize.gmdb.gmdb.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movie")
public class MovieController {

    private final MovieService movieService;


    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @RequestMapping(method= RequestMethod.GET,value="/movies")
    public List<Movie> getMovies() {

        List<Movie> movies = this.movieService.getMovies();

        return movies;
    }

    @RequestMapping(method= RequestMethod.GET,value="/movie/{id}")
    public Movie getMovie(@PathVariable("id") Long id) {

        Movie movie = this.movieService.getMovie(id);
        return movie;

    }

    @RequestMapping(method= RequestMethod.POST,value="/add")
    public void addMovie(@RequestBody Movie movie) {
        this.movieService.addMovie(movie);
    }

    @RequestMapping(method= RequestMethod.DELETE, value="/delete/{id}")
    public void deleteMovie(@PathVariable("id") Long id) {
        this.movieService.deleteMovie(id);
    }

    @RequestMapping(method= RequestMethod.PUT,value="/update")
    public void updateMovie(@RequestBody Movie movie) {
        this.movieService.updateMovie(movie);
    }


}
