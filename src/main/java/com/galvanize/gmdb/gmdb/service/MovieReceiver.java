package com.galvanize.gmdb.gmdb.service;

import com.galvanize.gmdb.gmdb.model.Movie;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class MovieReceiver {

    private final Logger logger = LoggerFactory.getLogger(MovieReceiver.class.getName());

    private final MovieService movieService;

    public MovieReceiver(MovieService movieService) {
        this.movieService = movieService;
    }

    @RabbitListener(queues="MovieQueue", containerFactory="jsaFactory")
    public void receive(Movie movie) {
        logger.info("Received movie [" + movie + "]");
        movieService.addMovie(movie);
    }


}
