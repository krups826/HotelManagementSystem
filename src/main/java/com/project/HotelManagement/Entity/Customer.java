package com.project.HotelManagement.Entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Customer {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long customerId;

        @Column(nullable = false)
        private String name;

        @Column(nullable = false,unique = true)
        private String email;

        @Column(nullable = false)
        private String password;


        @Column(nullable = false,unique = true,length = 10)
        private String phone;

        @Column(length = 100)
        private String address;

        private String otp;

        private boolean verified;

        @JsonIgnore
        @OneToMany(mappedBy = "customer")
        private List<Reservation> reservations;

}
