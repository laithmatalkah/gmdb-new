package com.galvanize.gmdb.gmdb.repository;

import com.galvanize.gmdb.gmdb.model.Movie;
import org.springframework.data.repository.CrudRepository;

public interface MovieRepository extends CrudRepository<Movie, Long> {
}
