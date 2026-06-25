package com.project.HotelManagement.Service;

import com.project.HotelManagement.Entity.RoomCategory;
import com.project.HotelManagement.Repository.RoomCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomCategoryService {

    @Autowired
    private RoomCategoryRepository roomCategoryRepository;

    //add
    public RoomCategory addRoomCategory(RoomCategory roomCategory){
        return roomCategoryRepository.save(roomCategory);
    }

    //get by id
    public Optional<RoomCategory> getRoomCategoryId(int categoryId){
        return roomCategoryRepository.findById(categoryId);
    }

    //get all
    public List<RoomCategory> getAllRoomCategory(){
        return roomCategoryRepository.findAll();
    }

    //update
    public RoomCategory updateRoomCategory(RoomCategory roomCategory){
        return roomCategoryRepository.save(roomCategory);
    }

    //delete
    public void deleteRoomCategory(long roomCategoryId){
        roomCategoryRepository.deleteById((int)roomCategoryId);
    }
}
