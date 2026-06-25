package com.project.HotelManagement.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendOtp(String to, String otp){

        SimpleMailMessage message = new SimpleMailMessage();

        message.setTo(to);
        message.setSubject("Hotel Registration OTP");
        message.setText("Your OTP is  : " + otp);

        mailSender.send(message);
    }
    public void sendReservationEmail(
            String to,
            String customerName,
            String roomName,
            String checkIn,
            String checkOut){

        SimpleMailMessage message =
                new SimpleMailMessage();

        message.setTo(to);

        message.setSubject(
                "Grand Heaven Reservation Confirmed");

        message.setText(

                "Dear " + customerName + ",\n\n" +

                        "Your room reservation is successful.\n\n" +

                        "Room: " + roomName + "\n" +

                        "Check-In: " + checkIn + "\n" +

                        "Check-Out: " + checkOut + "\n\n" +

                        "Thank you for choosing Grand Heaven."

        );

        mailSender.send(message);
    }
}
