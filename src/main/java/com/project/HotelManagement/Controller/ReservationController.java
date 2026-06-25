package com.project.HotelManagement.Controller;

import com.project.HotelManagement.Entity.Reservation;
import com.project.HotelManagement.Service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservation")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @PostMapping("/add")
    public Reservation bookroom(@RequestBody Reservation reservation){
        return reservationService.bookroom(reservation);
    }

    // get id
    @GetMapping("/{id}")
    public Reservation getReservationId(@PathVariable("id") long reservationId){
        return reservationService.getReservationId((int)reservationId);
    }

    //get all
    @GetMapping
    public List<Reservation> getAllReservation(){
        return reservationService.getAllReservation();
    }

    //update
    @PutMapping("/update")
    public Reservation updateReservation(@RequestBody Reservation reservation){
        return reservationService.updateReservation(reservation);
    }

    //delete
    @DeleteMapping("/{id}")
    public String deleteReservation(@PathVariable("id") long reservationId){
        reservationService.deleteReservation((int)reservationId);
        return  "Reservation Deleted SuccessFully";
    }
    @DeleteMapping("/cancel/{id}")
    public String cancelRoom(@PathVariable int reservationId){
        reservationService.cancelRoom(reservationId);
        return "Cancelled Room";
    }
}
