package com.project.HotelManagement.Service;

import com.project.HotelManagement.Entity.Cancellation;
import com.project.HotelManagement.Repository.CancellationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CancellationService {

    @Autowired
    private CancellationRepository cancellationRepository;

    public Cancellation createCancellation(Cancellation cancellation){
        return cancellationRepository.save(cancellation);
    }

    //get by id
    public Cancellation getCancellationId(long cancellationId){
        return cancellationRepository.findById((int) cancellationId).orElse(null);
    }

    //get all
    public List<Cancellation> getAllCancellation(){
        return cancellationRepository.findAll();
    }

    //delete
    public void deleteCancellation(long cancellationId){
        cancellationRepository.deleteById((int)cancellationId);
    }

}
