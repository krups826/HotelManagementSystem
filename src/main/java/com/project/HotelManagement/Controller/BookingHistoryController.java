package com.project.HotelManagement.Controller;

import com.project.HotelManagement.Entity.BookingHistory;
import com.project.HotelManagement.Service.BookingHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/bookingHistory")
public class BookingHistoryController {

    @Autowired
    private BookingHistoryService bookingHistoryService;

    @PostMapping("/add")
    public BookingHistory addBookingHistory(@RequestBody BookingHistory bookingHistory){
        return bookingHistoryService.addBookingHistory(bookingHistory);
    }
    // get id
    @GetMapping("/{id}")
    public BookingHistory getBookingHistoryId(@PathVariable("id") long historyId){
        return bookingHistoryService.getBookingHistoryId((int)historyId);
    }

    //get all
    @GetMapping
    public List<BookingHistory> getAllBookingHistory(){
        return bookingHistoryService.getAllBookingHistory();
    }

    //delete
    @DeleteMapping("/{id}")
    public String deleteBookingHistory(@PathVariable("id") long historyId){
        bookingHistoryService.deleteBookingHistory((int)historyId);
        return  "BookingHistory Deleted SuccessFully";
    }
}
