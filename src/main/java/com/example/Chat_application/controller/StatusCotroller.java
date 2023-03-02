package com.example.Chat_application.controller;


import com.example.Chat_application.model.Status;
import com.example.Chat_application.service.StatusService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StatusCotroller {

    @Autowired
    StatusService statusService;

    @PostMapping("savestatus")
    public ResponseEntity savestatus(@RequestBody String requeststatus){
        JSONObject json=new JSONObject(requeststatus);
        Status status=settatus(json);
        int id=statusService.savestatus(status);
        return new ResponseEntity<>("Status "+ id+ " saved", HttpStatus.CREATED);
    }

    private Status settatus(JSONObject json) {
        Status status=new Status();

        status.setStatus_name(json.getString("status_name"));
        status.setStatus_description("status_description");

        return status;
    }
}
