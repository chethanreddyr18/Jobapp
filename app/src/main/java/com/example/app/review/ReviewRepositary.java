package com.example.app.review;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ReviewRepositary extends JpaRepository<Review,Long> {

    List<Review> findByCompanyId(Long companyId);

    Optional<Review> findByCompanyIdAndId(Long companyId, Long reviewId);

}
