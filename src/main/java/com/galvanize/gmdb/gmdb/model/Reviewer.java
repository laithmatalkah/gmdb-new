package com.galvanize.gmdb.gmdb.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Entity(name = "REVIEWERS")
public class Reviewer {
    //Reviewer ID | Username | Date Joined | Number of Reviews

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "REVIEWER_ID")
    private long reviewerId;

    @Column(name = "USERNAME")
    private String userName;

    @Column(columnDefinition = "date", name = "DATE_JOINED")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dateJoined;

    @OneToMany(mappedBy = "reviewer", targetEntity = Review.class)
    private Collection reviews;

    public Reviewer(long reviewerId, String userName, Date dateJoined, Collection reviews) {
        this.reviewerId = reviewerId;
        this.userName = userName;
        this.dateJoined = dateJoined;
        this.reviews = reviews;
    }

    public long getReviewerId() {
        return reviewerId;
    }

    public void setReviewerId(long reviewerId) {
        this.reviewerId = reviewerId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getDateJoined() {
        return dateJoined;
    }

    public void setDateJoined(Date dateJoined) {
        this.dateJoined = dateJoined;
    }

    public Collection getReviews() {
        return reviews;
    }

    public void setReviews(Collection reviews) {
        this.reviews = reviews;
    }
}