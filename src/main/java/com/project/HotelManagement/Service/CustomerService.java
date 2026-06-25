package com.project.HotelManagement.Service;

import com.project.HotelManagement.Entity.Customer;
import com.project.HotelManagement.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

        @Autowired
        private CustomerRepository customerRepository;

        @Autowired
        private EmailService emailService;

        //add
        public Customer addCustomer(Customer customer){
            String otp = String.valueOf(
                    (int)(Math.random() * 900000)
                            + 100000
            );

            customer.setOtp(otp);

            customer.setVerified(false);

            Customer savedCustomer =
                    customerRepository.save(customer);

            emailService.sendOtp(
                    customer.getEmail(),
                    otp
            );

            return savedCustomer;
        }

        //get by id
        public Customer getCustomerId(long customerId){
            return customerRepository.findById((int) customerId).orElse(null);
        }

        //get all
        public List<Customer> getAllCustomer(){
            return customerRepository.findAll();
        }

        //update
        public Customer updateCustomer(Customer customer){
            return customerRepository.save(customer);
        }

        //delete
        public void deleteCustomer(long customerId){
            customerRepository.deleteById((int)customerId);
        }

        public Customer login(String email,String password){
            Customer customer = customerRepository.findByEmail(email);

            if(customer != null &&
                    customer.getPassword().equals(password)){

                return customer;
            }

            return null;
        }


}
