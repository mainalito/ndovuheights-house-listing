package com.ndovuheights.ndovuheights.Service;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ndovuheights.ndovuheights.Repository.HouseRepository;
import com.ndovuheights.ndovuheights.model.House;

@Service
public class HouseService implements HouseMethods {

  @Autowired
  private HouseRepository houseRepository;

  @Override
  public House saveRoom(House house) {

    return houseRepository.save(house);

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

  @Override
  public List<House> availableHouses() {
    return houseRepository.findByStatus(true);
  }

  @Override
  public House updateRoom(String roomNumber, House houseDetails)  {
    Optional<House> optionalHouse = houseRepository.findById(roomNumber);
    if(optionalHouse.isPresent()){
     House house = optionalHouse.get();
     house.setPrice(houseDetails.getPrice());
     house.setRoomNumber(houseDetails.getRoomNumber());
     house.setRoomType(houseDetails.getRoomType());
     house.setStatus(houseDetails.isStatus());
     saveRoom(house);
     return house;
    }
    return null;
  }

}
