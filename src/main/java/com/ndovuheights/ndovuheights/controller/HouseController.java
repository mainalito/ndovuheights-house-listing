package com.ndovuheights.ndovuheights.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ndovuheights.ndovuheights.Service.HouseService;
import com.ndovuheights.ndovuheights.model.House;

@RestController
public class HouseController {

    @Autowired
    HouseService houseService;
    
    @GetMapping("/room/{roomNumber}")
    public ResponseEntity<House> fetchOneHouse(@PathVariable String roomNumber){
        Optional<House> house = houseService.fetchOneRoom(roomNumber);
        if(house.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return  ResponseEntity.status(HttpStatus.OK).body(
            house.get()
        );
    }

    @GetMapping("/")
    public ResponseEntity<List<House>> fetchAllHouses(){
        return ResponseEntity.status(HttpStatus.OK).body(houseService.fetchAllRooms());
    }
    @PostMapping( value = "/room", consumes = "application/json")
    public ResponseEntity saveRoom(@RequestBody House house){
        Optional<House> houseOptional = houseService.fetchOneRoom(house.getRoomNumber());
        if(houseOptional.isEmpty()){

            houseService.saveRoom(house);
            return ResponseEntity.ok(HttpStatus.CREATED);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ALREADY EXISTS");
    }
    @DeleteMapping("/room/{roomNumber}")
    public ResponseEntity<String> deleteRoom(@PathVariable String roomNumber){
        houseService.deleteRoom(roomNumber);
        return ResponseEntity.status(HttpStatus.OK).body("Room number "+ roomNumber + " has been deleted");
    }
}
