package com.project.HotelManagement.Repository;

import com.project.HotelManagement.Entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoomRepository extends JpaRepository<Room,Integer> {
    List<Room> findByStatus(String status);
}
