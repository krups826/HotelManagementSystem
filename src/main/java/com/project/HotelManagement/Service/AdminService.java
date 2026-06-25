package com.project.HotelManagement.Service;

import com.project.HotelManagement.Entity.Admin;
import com.project.HotelManagement.Entity.Customer;
import com.project.HotelManagement.Repository.AdminRepository;
import com.project.HotelManagement.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    //add
    public Admin addAdmin(Admin admin){
        return adminRepository.save(admin);
    }

    //get by id
    public Admin getAdminId(long adminId){
        return adminRepository.findById((int) adminId).orElse(null);
    }

    //get all
    public List<Admin> getAllAdmin(){
        return adminRepository.findAll();
    }

    //update
    public Admin updateAdmin(Admin admin){
        return adminRepository.save(admin);
    }

    //delete
    public void deleteAdmin(long adminId){
        adminRepository.deleteById((int)adminId);
    }

    //login
    public Admin login(String email, String password){

        Admin admin =
                adminRepository.findByEmail(email);

        if(admin != null &&
                admin.getPassword().equals(password)){

            return admin;
        }

        return null;
    }
}
