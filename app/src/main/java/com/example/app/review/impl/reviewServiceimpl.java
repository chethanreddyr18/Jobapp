package com.example.app.review.impl;


import com.example.app.comapny.CompanyService;
import com.example.app.review.Review;
import com.example.app.review.ReviewRepositary;
import com.example.app.review.ReviewService;
import org.springframework.stereotype.Service;
import com.example.app.comapny.Company;

import java.util.List;
import java.util.Optional;

@Service
public class reviewServiceimpl implements ReviewService {
    private final ReviewRepositary reviewRepositary;
    private final CompanyService companyService;

    public reviewServiceimpl(ReviewRepositary reviewRepositary,CompanyService companyService) {
        this.reviewRepositary = reviewRepositary;
        this.companyService = companyService;
    }


    @Override
    public List<Review> getAllReview(Long companyId) {
        List<Review> reviews = reviewRepositary.findByCompanyId(companyId);
        return reviews;
    }

    @Override
    public boolean addReview(Long companyId, Review review) {
        Company company = companyService.getById(companyId);
        if(company !=null){
            review.setCompany(company);
            reviewRepositary.save(review);
            return true;
        }
        return false;

    }

    @Override
    public Review reviewById(Long companyId, Long reviewId) {
        return reviewRepositary.findByCompanyIdAndId(companyId, reviewId)
                .orElse(null);
    }

    @Override
    public boolean updateReview(Long companyId, Long reviewId, Review updatedReview) {
        if(companyService.getById(companyId)!=null){
            updatedReview.setCompany(companyService.getById(companyId));
            updatedReview.setId(reviewId);
            reviewRepositary.save(updatedReview);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteByid(Long companyId, Long reviewId) {
        if(companyService.getById(companyId)!=null){
            Review review = reviewRepositary.findById(reviewId).orElse(null);
            Company company = review.getCompany();
            company.getReview().remove(review);
            companyService.updateCompany(companyId,company);
            reviewRepositary.deleteById(reviewId);
            return true;
        }
        return false;
    }
}
