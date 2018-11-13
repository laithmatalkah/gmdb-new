package com.galvanize.gmdb.gmdb;

import java.time.LocalTime;

public class Movie {

    private Long movieID;
    private String title;
    private Integer yearReleased;
    private String Genre;
    private Double runTime;

    public Movie(Long movieID, String title, Integer yearReleased, String genre, Double runTime) {
        this.movieID = movieID;
        this.title = title;
        this.yearReleased = yearReleased;
        Genre = genre;
        this.runTime = runTime;
    }

    public Long getMovieID() {
        return movieID;
    }

    public String getTitle() {
        return title;
    }

    public Integer getYearReleased() {
        return yearReleased;
    }

    public String getGenre() {
        return Genre;
    }

    public Double getRunTime() {
        return runTime;
    }
}
