package com.ndovuheights.ndovuheights.Service;

import java.util.List;
import java.util.Optional;

import javax.naming.NameNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ndovuheights.ndovuheights.Repository.HouseRepository;
import com.ndovuheights.ndovuheights.model.House;

@Service
public class HouseService implements HouseMethods {

    @Autowired
    private HouseRepository houseRepository;
    @Override
    public void saveRoom(House house) {
    
        houseRepository.save(house);
        
    }

    @Override
    public List<House> fetchAllRooms() {
         return houseRepository.findAll();
        
    }

    @Override
    public Optional<House> fetchOneRoom(String roomNumber) {
      return houseRepository.findById(roomNumber);
        
    }

    @Override
    public void deleteRoom(String roomNumber) {
         houseRepository.deleteById(roomNumber);
    }
    
}
