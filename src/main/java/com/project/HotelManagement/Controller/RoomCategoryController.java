package com.project.HotelManagement.Controller;


import com.project.HotelManagement.Entity.RoomCategory;
import com.project.HotelManagement.Service.RoomCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/RoomCategory")
public class RoomCategoryController {

    @Autowired
    private RoomCategoryService roomCategoryService;

    //add
    @PostMapping("/add")
    public RoomCategory addRoomCategory(@RequestBody RoomCategory roomCategory){
        return roomCategoryService.addRoomCategory(roomCategory);
    }

    // get id
    @GetMapping("/{id}")
    public Optional<RoomCategory> getRoomCategoryId(@PathVariable("id") int categoryId){
        return roomCategoryService.getRoomCategoryId(categoryId);
    }

    //get all
    @GetMapping
    public List<RoomCategory> getAllRoomCategory(){
        return roomCategoryService.getAllRoomCategory();
    }

    //update
    @PutMapping("/update")
    public RoomCategory updateRoomCategory(@RequestBody RoomCategory roomCategory){
        return roomCategoryService.updateRoomCategory(roomCategory);
    }

    //delete
    @DeleteMapping("/{id}")
    public String deleteRoomCategory(@PathVariable("id") int categoryId){
        roomCategoryService.deleteRoomCategory(categoryId);
        return  "RoomCategory Deleted SuccessFully";
    }
}
