package com.project.HotelManagement.Controller;

import com.project.HotelManagement.Entity.Cancellation;
import com.project.HotelManagement.Service.CancellationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cancellation")
public class CancellationController {

    @Autowired
    private CancellationService cancellationService;

    @PostMapping("/add")
    public Cancellation createCancellation(@RequestBody Cancellation cancellation){
        return cancellationService.createCancellation(cancellation);
    }
    // get id
    @GetMapping("/{id}")
    public Cancellation getCancellationId(@PathVariable("id") long cancellationId){
        return cancellationService.getCancellationId((int)cancellationId);
    }

    //get all
    @GetMapping
    public List<Cancellation> getAllCancellation(){
        return cancellationService.getAllCancellation();
    }

    //delete
    @DeleteMapping("/{id}")
    public String deleteCancellation(@PathVariable("id") long cancellationId){
        cancellationService.deleteCancellation((int)cancellationId);
        return  "Cancellation Deleted SuccessFully";
    }
}
