package com.practo.service;

import com.practo.entity.Review;
import com.practo.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.practo.repository.DoctorRepository;
import com.practo.repository.PatientRepository;

import java.util.List;
import java.util.OptionalDouble;


@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepo;

    @Autowired
    private DoctorRepository doctorRepo;

    @Autowired
    private PatientRepository patientRepo;

    public Review saveReview(Review review) {

        long doctorId = Integer.parseInt(review.getDoctorId());
        long patientId = Integer.parseInt(review.getPatientId());

        if (doctorRepo.existsById(doctorId) && patientRepo.existsById(patientId)) {
            return reviewRepo.save(review);
        } else {
            throw new IllegalArgumentException("Doctor or Patient does not exist");
        }
    }

    public List<Review> getReviewByDocId(long id) {
        List<Review> reviewByDocId = reviewRepo.getReviewByDocId(id);
        return reviewByDocId;
    }
    public double calculateDoctorRating(long doctorId) {
        List<Review> reviews = reviewRepo.getReviewByDocId(doctorId);
        OptionalDouble averageRating = reviews.stream()
                .mapToInt(Review::getRating)
                .average();

        return averageRating.isPresent() ? averageRating.getAsDouble() : 0.0;
    }
}
