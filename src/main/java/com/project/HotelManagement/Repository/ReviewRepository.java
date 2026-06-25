package com.project.HotelManagement.Repository;

import com.project.HotelManagement.Entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository
        extends JpaRepository<Review, Integer> {
}