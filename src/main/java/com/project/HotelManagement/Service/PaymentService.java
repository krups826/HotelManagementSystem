package com.project.HotelManagement.Service;

import com.project.HotelManagement.Entity.Payment;
import com.project.HotelManagement.Repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    //get by id
    public Payment getPaymentId(long paymentId){
        return paymentRepository.findById((int) paymentId).orElse(null);
    }

    //get all
    public List<Payment> getAllPayment(){
        return paymentRepository.findAll();
    }

    //update
    public Payment updatePayment(Payment payment){
        return paymentRepository.save(payment);
    }

    //delete
    public void deletePayment(long paymentId){
        paymentRepository.deleteById((int)paymentId);
    }
    
    //make payment
    public Payment makePayment(Payment payment){
        return paymentRepository.save(payment);
    }
}
