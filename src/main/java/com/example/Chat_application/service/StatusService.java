package com.example.Chat_application.service;


import com.example.Chat_application.dao.IStatusRepository;
import com.example.Chat_application.model.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatusService {


    @Autowired
    IStatusRepository statusRepository;
    public int savestatus(Status status) {
        statusRepository.save(status);
        return status.getStatus_id();
    }
}
