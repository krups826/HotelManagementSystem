package com.project.HotelManagement.Service;

import com.project.HotelManagement.Entity.Review;
import com.project.HotelManagement.Repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    public Review addReview(
            Review review){

        return reviewRepository
                .save(review);
    }

    public List<Review> getAllReviews(){

        return reviewRepository
                .findAll();
    }
}