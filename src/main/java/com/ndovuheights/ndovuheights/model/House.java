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
    @Column(unique = true, nullable = false)
    private String roomNumber;
    @Column(nullable = false)
    private String roomType;
    @Column(nullable = false)
    private double price;
    @Column(nullable = false)
    private boolean status;
}
