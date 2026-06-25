package com.project.HotelManagement.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int reviewId;

    private int rating; // 1 to 5 stars

    private String comment;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
}
