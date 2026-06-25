package com.project.HotelManagement.Repository;

import com.project.HotelManagement.Entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository  extends JpaRepository<Customer,Integer> {

    Customer findByEmail(String email);
}

