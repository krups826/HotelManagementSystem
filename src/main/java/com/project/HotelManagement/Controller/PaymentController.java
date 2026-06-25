package com.project.HotelManagement.Controller;

import com.project.HotelManagement.Entity.Payment;
import com.project.HotelManagement.Service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payment")
public class PaymentController {
        @Autowired
        private PaymentService paymentService;

    // get id
    @GetMapping("/{id}")
    public Payment getPaymentId(@PathVariable("id") long paymentId){
        return paymentService.getPaymentId((int)paymentId);
    }

    //get all
    @GetMapping
    public List<Payment> getAllPayment(){
        return paymentService.getAllPayment();
    }

    //update
    @PutMapping("/update")
    public Payment updatePayment(@RequestBody Payment payment){
        return paymentService.updatePayment(payment);
    }

    //delete
    @DeleteMapping("/{id}")
    public String deletePayment(@PathVariable("id") long paymentId){
        paymentService.deletePayment((int)paymentId);
        return  "Payment Deleted SuccessFully";
    }

    @PostMapping("/make")
    public Payment makePayment(@RequestBody Payment payment){
        return paymentService.makePayment(payment);
    }
}
