package com.project.HotelManagement.Repository;

import com.project.HotelManagement.Entity.Cancellation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CancellationRepository extends JpaRepository<Cancellation,Integer> {
}
