package com.example.Ev_charging_station.Controller;


import com.example.Ev_charging_station.Model.Station;
import com.example.Ev_charging_station.Service.Stationservice;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Stationcontroller {

    @Autowired //create bean when we need
    Stationservice stationservice;  //field dependency injection


    @PostMapping("savestation") // for save.post station/ create new station
    public ResponseEntity savestation(@RequestBody String requeststation){
        JSONObject newstation=new JSONObject(requeststation);
        Station station=setstation(newstation);
        stationservice.savestation(station);

        return new ResponseEntity<>("Station saved", HttpStatus.CREATED);
    }

    @GetMapping("getstation") // get request for get station list
    public List<Station> getstation(@Nullable @RequestParam Integer station_id){
        List<Station> stations=stationservice.getstation(station_id);
        return stations;
    }

    @PutMapping("Updatestation/{station_id}")  // for update station
    public ResponseEntity updatestation(@PathVariable Integer station_id, @RequestBody Station newstation){
        Integer id=stationservice.updatestation(newstation,station_id);
        return new ResponseEntity<>("station no "+ id+" updated",HttpStatus.OK);
    }


    @DeleteMapping("deletestation")  // for delete station
    public ResponseEntity  deletestation(@RequestParam Integer station_id){
        Integer id=stationservice.deletestation(station_id);
        return new ResponseEntity<>("station no "+id+" deleted",HttpStatus.OK);
    }

    private Station setstation(JSONObject json) {
        Station station=new Station();

        //station.setStation_id(json.getInt("station_id")); bcz id is autoincrement
        station.setStation_name(json.getString("station_name"));
        station.setStation_image(json.getString("station_image"));
        station.setStation_pricing(json.getString("station_pricing"));
        station.setStation_address(json.getString("station_address"));

        return station;

    }

}
