package com.project.HotelManagement.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Entity
@ToString
@Data
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int roomId;

    private int roomNumber;

    @Column(length = 50)
    private String roomType;

    @Column(nullable = false)
    private double price;

    @Column(nullable = false)
    private String status;

    @JsonIgnore
    @OneToMany(mappedBy = "room")
    private List<Reservation> reservations;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private RoomCategory roomCategory;
}
