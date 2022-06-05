package com.ndovuheights.ndovuheights.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class House {
    @Id
    private String roomNumber;
    private String roomType;
    private double price;
    private boolean status;
}
