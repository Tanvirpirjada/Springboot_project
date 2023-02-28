package com.example.Ev_charging_station.Service;


import com.example.Ev_charging_station.Dao.IStationrepository;
import com.example.Ev_charging_station.Model.Station;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class Stationservice {

    @Autowired
    IStationrepository stationrepository;
    public void savestation(Station station) {
        stationrepository.save(station); //save station into database
    }

    public List<Station> getstation(Integer stationId) {
        List<Station> stationList;
        if(stationId!=null ){
            stationList=new ArrayList<>();
            stationList.add(stationrepository.findById(stationId).get());
        }

        else{
            stationList=stationrepository.findAll();
        }
        return stationList;
    }

    public Integer updatestation(Station newstation, Integer stationId) {

        Station oldstation=stationrepository.findById(stationId).get();

        newstation.setStation_id(oldstation.getStation_id());

        stationrepository.save(newstation);
        return newstation.getStation_id();
    }

    public Integer deletestation(Integer stationId) {

        Station station=stationrepository.findById(stationId).get();

        stationrepository.delete(station);

        return station.getStation_id();
    }
}
