package com.project.HotelManagement.Controller;

import com.project.HotelManagement.Entity.Admin;
import com.project.HotelManagement.Service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/add")
    public Admin addAdmin(@RequestBody Admin admin){
        return adminService.addAdmin(admin);
    }

    @PostMapping("/login")
    public Admin login(
            @RequestBody Admin admin){

        return adminService.login(
                admin.getEmail(),
                admin.getPassword()
        );
    }
    @GetMapping("/{id}")
    public Admin getAdminId(@PathVariable("id") long adminId){
        return adminService.getAdminId((int)adminId);
    }

    @GetMapping
    public List<Admin> getAllAdmin(){
        return adminService.getAllAdmin();
    }

    @PutMapping("/update")
    public Admin updateAdmin(@RequestBody Admin admin){
        return adminService.updateAdmin(admin);
    }

    @DeleteMapping
    public String deleteAdmin(@PathVariable long adminId){
        adminService.deleteAdmin((int)adminId);
        return " delete admin";
    }
}
