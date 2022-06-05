package com.ndovuheights.ndovuheights.Service;

import java.util.List;
import java.util.Optional;

import javax.naming.NameNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;

import com.ndovuheights.ndovuheights.Repository.HouseRepository;
import com.ndovuheights.ndovuheights.model.House;

public class HouseService implements HouseMethods {

    @Autowired
    private HouseRepository houseRepository;
    @Override
    public void saveRoom(House house) {
        house.setStatus(false);
        houseRepository.save(house);
        
    }

    @Override
    public List<House> fetchAllRooms() {
         return houseRepository.findAll();
        
    }

    @Override
    public House fetchOneRoom(String roomNumber) {
      return houseRepository.findById(roomNumber).get();
        
    }

    @Override
    public void deleteRoom(String roomNumber) {
         houseRepository.deleteById(roomNumber);
    }
    
}
