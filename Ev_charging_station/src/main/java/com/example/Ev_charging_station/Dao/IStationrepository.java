package com.example.Ev_charging_station.Dao;

import com.example.Ev_charging_station.Model.Station;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IStationrepository extends JpaRepository<Station,Integer> {
}
