package com.project.HotelManagement.Repository;

import com.project.HotelManagement.Entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation,Integer> {
}
