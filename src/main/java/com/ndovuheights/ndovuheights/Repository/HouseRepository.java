package com.ndovuheights.ndovuheights.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ndovuheights.ndovuheights.model.House;

public interface HouseRepository extends JpaRepository<House,String> {

    List<House> findByStatus(boolean status);

    Optional<House> findByRoomNumber(String roomNumber);

    
    
}
