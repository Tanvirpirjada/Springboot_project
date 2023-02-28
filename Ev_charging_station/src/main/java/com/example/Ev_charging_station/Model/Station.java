package com.example.Ev_charging_station.Model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity //for creating table in database
@Data    // for getter and setters
@NoArgsConstructor
@AllArgsConstructor
public class Station {

    @Id //make primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto increment
    private Integer station_id;

    private String station_name;

    private String station_image;

    private String station_pricing;

    private String station_address;


}
