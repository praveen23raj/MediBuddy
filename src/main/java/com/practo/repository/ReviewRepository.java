package com.practo.repository;

import com.practo.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review,Long> {

//    @Query("select * from Review r where r.doctorId=:id")
//    List<Review> getReviewByDocId(@Param("id") long id);

    @Query("SELECT r FROM Review r WHERE r.doctorId = :id")
    List<Review> getReviewByDocId(@Param("id") long id);
}
