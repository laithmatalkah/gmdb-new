package com.galvanize.gmdb.gmdb.service;

import com.galvanize.gmdb.gmdb.model.Movie;
import com.galvanize.gmdb.gmdb.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> getMovies() {
        return (List) movieRepository.findAll();
    }

    public Movie getMovie(Long id) {
        return movieRepository.findById(id).get();
    }

    public void addMovie(Movie movie) {
        this.movieRepository.save(movie);
    }

    public void updateMovie(Movie movie) {
        this.movieRepository.save(movie);
    }

    public void deleteMovie(Long id) {
        this.movieRepository.deleteById(id);
    }
}
