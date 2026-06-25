package com.project.HotelManagement.Service;

import com.project.HotelManagement.Entity.Customer;
import com.project.HotelManagement.Entity.Reservation;
import com.project.HotelManagement.Repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private EmailService emailService;

    // book room
    public Reservation bookroom(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    // cancel room
    public void cancelRoom(int reservationId) {
        reservationRepository.deleteById(reservationId);
    }

    //get by id
    public Reservation getReservationId(long reservationId) {
        return reservationRepository.findById((int) reservationId).orElse(null);
    }

    //get all
    public List<Reservation> getAllReservation() {
        return reservationRepository.findAll();
    }

    //update
    public Reservation updateReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    //delete
    public void deleteReservation(long reservationId) {
        reservationRepository.deleteById((int) reservationId);
    }

    public Reservation addReservation(Reservation reservation) {
        Reservation savedReservation =
                reservationRepository
                        .save(reservation);

        emailService.sendReservationEmail(

                reservation.getCustomer()
                        .getEmail(),

                reservation.getCustomer()
                        .getName(),

                String.valueOf(
                        reservation.getRoom()
                                .getRoomNumber()
                ),
                reservation.getCheckInDate()
                        .toString(),

                reservation.getCheckOutDate()
                        .toString()

        );

        return savedReservation;

    }
}