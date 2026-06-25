package com.project.HotelManagement.Service;

import com.project.HotelManagement.Entity.BookingHistory;
import com.project.HotelManagement.Repository.BookingHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingHistoryService {

    @Autowired
    private BookingHistoryRepository bookingHistoryRepository;


    //add
    public BookingHistory addBookingHistory(BookingHistory bookingHistory){
        return bookingHistoryRepository.save(bookingHistory);
    }

    //get by id
    public BookingHistory getBookingHistoryId(int historyId){
        return bookingHistoryRepository.findById(historyId).orElse(null);
    }

    //get all
    public List<BookingHistory> getAllBookingHistory(){
        return bookingHistoryRepository.findAll();
    }

    //delete
    public void deleteBookingHistory(int historyId){
        bookingHistoryRepository.deleteById(historyId);
    }
}
