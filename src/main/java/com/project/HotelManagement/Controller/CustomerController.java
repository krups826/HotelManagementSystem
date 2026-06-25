package com.project.HotelManagement.Controller;

import com.project.HotelManagement.Entity.Customer;
import com.project.HotelManagement.Repository.CustomerRepository;
import com.project.HotelManagement.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private CustomerRepository customerRepository;

    //add
    @PostMapping("/add")
    public String addCustomer(@RequestBody Customer customer){
         customerService.addCustomer(customer);
        return "Registration Successful";
    }

    // get id
    @GetMapping("/{id}")
    public Customer getCustomerId(@PathVariable("id") long customerId){
        return customerService.getCustomerId((int)customerId);
    }

    //get all
    @GetMapping
    public List<Customer> getAllCustomer(){
        return customerService.getAllCustomer();
    }

    //update
    @PutMapping("/update")
    public Customer updateCustomer(@RequestBody Customer customer){
        return customerService.updateCustomer(customer);
    }

    //delete
    @DeleteMapping("/{id}")
    public String deleteCustomer(@PathVariable("id") long customerId){
        customerService.deleteCustomer((int)customerId);
        return  "Customer Deleted SuccessFully";
    }

    @PostMapping("/login")
    public Customer login(@RequestBody Customer customer){
        return customerService.login(customer.getEmail(),customer.getPassword());
        }

    @PostMapping("/verify")
    public String verifyOtp(@RequestParam String email,@RequestParam String otp){
        Customer customer = customerRepository.findByEmail(email);

        if(customer != null && customer.getOtp().equals(otp)){

            customer.setVerified(true);
            customerRepository.save(customer);
            return "Verified";

        }
        return "Invalid OTP";
    }
}
