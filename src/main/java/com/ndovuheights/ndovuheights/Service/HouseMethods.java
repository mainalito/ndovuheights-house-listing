package com.ndovuheights.ndovuheights.Service;

import java.util.List;

import com.ndovuheights.ndovuheights.model.House;

public interface HouseMethods {
    void saveRoom(House house);
    List<House> fetchAllRooms();
    House fetchOneRoom(String roomNumber);
    void deleteRoom(String roomNumber);
}
