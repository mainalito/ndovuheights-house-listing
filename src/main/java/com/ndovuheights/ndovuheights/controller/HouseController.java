package com.ndovuheights.ndovuheights.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ndovuheights.ndovuheights.Repository.HouseRepository;
import com.ndovuheights.ndovuheights.Responses.ResponseHandler;
import com.ndovuheights.ndovuheights.Service.HouseService;
import com.ndovuheights.ndovuheights.model.House;

@RestController
public class HouseController {

    @Autowired
    HouseService houseService;

    @GetMapping("/room/{roomNumber}")
    public ResponseEntity<Object> fetchOneHouse(@PathVariable String roomNumber) {

        Optional<House> house = houseService.fetchOneRoom(roomNumber);
        if (house.isEmpty()) {
            return ResponseHandler.generateResponse("Not Found", HttpStatus.NOT_FOUND, null);
        }
        return ResponseHandler.generateResponse("Successfully retrieved Data!", HttpStatus.OK, house.get());
    }

    @GetMapping("/room/available")
    public ResponseEntity<Object> availableHouses() {
        try {
            // filter to true to indicate available rooms
            List<House> houses = houseService.fetchAllRooms().stream()
                    .filter(x -> x.isStatus() == true).collect(Collectors.toList());
            return ResponseHandler.generateResponse("Available rooms", HttpStatus.OK, houses);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }

    @GetMapping("/")
    public ResponseEntity<Object> fetchAllHouses() {
        try {
            List<House> houses = houseService.fetchAllRooms();
            return ResponseHandler.generateResponse("Successfully retrieved data!", HttpStatus.OK, houses);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }

    @PostMapping(value = "/room", consumes = "application/json")
    public ResponseEntity<Object> saveRoom(@RequestBody @Validated House house) {
        try {
            house = houseService.saveRoom(house);
            return ResponseHandler.generateResponse("Successfully added data", HttpStatus.CREATED, house);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }

    @DeleteMapping("/room/{roomNumber}")
    public ResponseEntity<Object> deleteRoom(@PathVariable String roomNumber) {
        try {
            houseService.deleteRoom(roomNumber);
            return ResponseHandler.generateResponse("Deleted", HttpStatus.OK, null);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }
    @PutMapping(value = "/room/{roomNumber}", consumes = "application/json")
    public ResponseEntity<Object> updateRoom(@PathVariable String roomNumber, @Validated @RequestBody House houseDetails){
        try {
      House house =  houseService.updateRoom(roomNumber, houseDetails);
            return ResponseHandler.generateResponse("Successfully updated!", HttpStatus.OK, house);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }
}
