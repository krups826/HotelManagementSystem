package com.project.HotelManagement.Controller;

import com.project.HotelManagement.Entity.Review;
import com.project.HotelManagement.Service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reviews")
@CrossOrigin("*")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @PostMapping("/add")
    public Review addReview(
            @RequestBody Review review){

        return reviewService
                .addReview(review);
    }

    @GetMapping
    public List<Review> getAllReviews(){

        return reviewService
                .getAllReviews();
    }
    @GetMapping("/reviews") // This matches the URL link clicked by the user
    public String showReviewsPage() {
        // CHANGE THIS LINE: Change "feedback" to "reviews"
        return "reviews";
    }
}