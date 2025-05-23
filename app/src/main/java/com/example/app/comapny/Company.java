package com.example.app.comapny;

import com.example.app.job.Job;
import com.example.app.review.Review;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.*;

@Entity
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String location;
    private Long members;

    @JsonIgnore
    @OneToMany(mappedBy = "company")
    private List<Job> job;

    @OneToMany(mappedBy = "company")
    private List<Review> review;

    public Company() {
    }

    public Company(Long id, String name, String location, Long members) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.members = members;
    }

    public List<Review> getReview() {
        return review;
    }

    public void setReview(List<Review> review) {
        this.review = review;
    }

    public Long getId() {
        return id;
    }

    public List<Job> getJob() {
        return job;
    }

    public void setJob(List<Job> job) {
        this.job = job;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Long getMembers() {
        return members;
    }

    public void setMembers(Long members) {
        this.members = members;
    }
}
