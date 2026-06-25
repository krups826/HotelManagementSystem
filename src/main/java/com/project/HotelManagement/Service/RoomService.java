package com.project.HotelManagement.Service;

import com.project.HotelManagement.Entity.Customer;
import com.project.HotelManagement.Entity.Room;
import com.project.HotelManagement.Repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {

    @Autowired
    private RoomRepository roomRepository;

    //add
    public Room addRoom(Room room){
        return roomRepository.save(room);
    }

    //get by id
    public Room getRoomId(int roomId){
        return roomRepository.findById(roomId).orElse(null);
    }

    //get all
    public List<Room> getAllRoom(){
        return roomRepository.findAll();
    }

    //update
    public Room updateRoom(Room room){
        return roomRepository.save(room);
    }

    //delete
    public void deleteRoom(long roomId){
        roomRepository.deleteById((int)roomId);
    }

    //search available room
    public List<Room> getAvailableRoom(){
        return roomRepository.findByStatus("available");
    }
}
