package com.example.app.review;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies/{companyId}/review")
public class reviewController {

    private ReviewService reviewService;

    public reviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping
    public ResponseEntity<List<Review>> getAllReviews(@PathVariable Long companyId){
        return new ResponseEntity<>(reviewService.getAllReview(companyId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> addReview(@PathVariable Long companyId,@RequestBody Review review){
           boolean rs =  reviewService.addReview(companyId,review);
           if(rs)
                return new ResponseEntity<>("Success",HttpStatus.OK);
           return new ResponseEntity<>("Not saved",HttpStatus.NOT_FOUND);
    }
    @GetMapping("/{reviewId}")
    public ResponseEntity<Review> reviewById(@PathVariable Long companyId,@PathVariable Long reviewId){
            return new ResponseEntity<>(reviewService.reviewById(companyId,reviewId),HttpStatus.OK);
    }

    @PutMapping("/{reviewId}")
    public ResponseEntity<String> updateReview(@PathVariable Long companyId,@PathVariable Long reviewId,
                                                @RequestBody Review review){
        boolean ru = reviewService.updateReview(companyId,reviewId,review);
        if(ru)
            return new ResponseEntity<>("updated",HttpStatus.OK);
        else
            return new ResponseEntity<>("Not updated",HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{reviewId}")

    public ResponseEntity<String> deleteById(@PathVariable Long companyId,@PathVariable Long reviewId){
        boolean delbyId = reviewService.deleteByid(companyId,reviewId);
        if(delbyId)
            return new ResponseEntity<>("deleted",HttpStatus.OK);
        else
            return new ResponseEntity<>("Not deleted",HttpStatus.NOT_FOUND);
    }
}
