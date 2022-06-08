package com.ndovuheights.ndovuheights.Service;

import java.util.List;
import java.util.Optional;

import com.ndovuheights.ndovuheights.model.House;

public interface HouseMethods {
    House saveRoom(House house);
    List<House> fetchAllRooms();
    Optional<House> fetchOneRoom(String roomNumber);
    void deleteRoom(String roomNumber);
    List<House>availableHouses();
    House  updateRoom(String roomNumber, House houseDetails);
}
