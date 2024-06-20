package com.practo.controller;

import com.practo.entity.Review;
import com.practo.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/review")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @PostMapping
    public ResponseEntity<Review> saveReview(@RequestBody Review review){
        Review savedReview = reviewService.saveReview(review);
        return new ResponseEntity<>(savedReview,HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<Review>> getReviewByDocId(@PathVariable long id){
        List<Review> reviewByDocId = reviewService.getReviewByDocId(id);
        return new ResponseEntity<>(reviewByDocId,HttpStatus.OK);
    }
    @GetMapping("/rating/{doctorId}")
    public ResponseEntity<Double> getDoctorRating(@PathVariable long doctorId) {
        double rating = reviewService.calculateDoctorRating(doctorId);
        return ResponseEntity.ok(rating);
    }

}
