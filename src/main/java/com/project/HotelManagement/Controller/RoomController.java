package com.project.HotelManagement.Controller;

import com.project.HotelManagement.Entity.Room;
import com.project.HotelManagement.Service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/room")
public class RoomController {

        @Autowired
        private RoomService roomService;

    @PostMapping("/add")
    public Room addRoom(@RequestBody Room room){
        return roomService.addRoom(room);
    }

    // get id
    @GetMapping("/{id}")
    public Room getRoomId(@PathVariable("id") long roomId){
        return roomService.getRoomId((int)roomId);
    }

    //get all
    @GetMapping
    public List<Room> getAllRoom(){
        return roomService.getAllRoom();
    }

    //update
    @PutMapping("/update")
    public Room updateRoom(@RequestBody Room room){
        return roomService.updateRoom(room);
    }

    //delete
    @DeleteMapping("/{id}")
    public String deleteRoom(@PathVariable("id") long roomId){
        roomService.deleteRoom((int)roomId);
        return  "Room Deleted SuccessFully";
    }

    @GetMapping("/available")
    public List<Room> getAvailableRoom(){
        return roomService.getAvailableRoom();
    }
}
