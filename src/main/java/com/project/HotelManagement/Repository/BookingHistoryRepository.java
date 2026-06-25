package com.project.HotelManagement.Repository;

import com.project.HotelManagement.Entity.BookingHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingHistoryRepository extends JpaRepository<BookingHistory,Integer> {
}
