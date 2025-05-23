package com.example.app.review;

import org.springframework.http.HttpStatusCode;

import java.util.List;

public interface ReviewService {

    List<Review> getAllReview(Long comapnyId);
    boolean addReview(Long companyId,Review review);
    Review reviewById(Long companyId,Long reviewId);
    boolean updateReview(Long companyId,Long reviewId,Review review);

    boolean deleteByid(Long companyId, Long reviewId);
}
