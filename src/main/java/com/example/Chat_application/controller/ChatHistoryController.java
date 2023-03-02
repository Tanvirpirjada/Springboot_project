package com.example.Chat_application.controller;


import com.example.Chat_application.dao.IStatusRepository;
import com.example.Chat_application.dao.IUserRepository;
import com.example.Chat_application.model.ChatHistory;
import com.example.Chat_application.model.Status;
import com.example.Chat_application.model.Users;
import com.example.Chat_application.service.ChatHistoryService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;


@RestController
public class ChatHistoryController {

    @Autowired
    ChatHistoryService chatHistoryService;

    @Autowired
    IUserRepository userRepository;

    @Autowired
    IStatusRepository statusRepository;


    @GetMapping("seechats")
    public ResponseEntity<String> seechats(@RequestParam int user1, @RequestParam int user2){
        JSONObject jsonObject=chatHistoryService.seechats(user1,user2);
        return new ResponseEntity<>(jsonObject.toString(),HttpStatus.OK);
    }


    @PostMapping("savemassage")
    public ResponseEntity savemassage(@RequestBody String requestmassage){
        JSONObject chatdetails=new JSONObject(requestmassage);
        JSONObject errorlist=validateMassage(chatdetails);
        if(errorlist.isEmpty()){
            ChatHistory chat=setChat(chatdetails);
            chatHistoryService.savechat(chat);
        }
        else{
            return new ResponseEntity<>(errorlist.toString(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("chat saved",HttpStatus.CREATED);
    }
    

    private ChatHistory setChat(JSONObject json) {

        ChatHistory chat=new ChatHistory();
        Integer senderId= json.getInt("sender");
        Integer receiverId= json.getInt("receiver");

        Users sender=userRepository.findByuserId(senderId).get(0);
        Users receiver=userRepository.findByuserId(receiverId).get(0);

        chat.setFrom_user(sender);
        chat.setTo_user(receiver);

        chat.setMassage(json.getString("massage"));

        Timestamp created_time=new Timestamp(System.currentTimeMillis());
        chat.setCreated_time(created_time);


        Integer statusId= json.getInt("statusId");
        Status statusid=statusRepository.findById(statusId).get();

        chat.setStatusId(statusid);

        return chat;

    }

    private JSONObject validateMassage(JSONObject json) {
        JSONObject jsonObject=new JSONObject();
        if(!json.has("sender")){
            jsonObject.put("sender","must have to select sender for send massage");
        }

        if(!json.has("receiver")){
            jsonObject.put("receiver","must have to select receiver for reaciving massgae");
        }

        if(!json.has("statusId")){
            jsonObject.put("statusId","status id requered for check the user is active or not");
        }

        if(!json.has("massage")){
            jsonObject.put("massage","massage body is requered");
        }
        else if(json.getString("massage").isEmpty()){
            jsonObject.put("massage","massage Body not be blank");
        }
        return jsonObject;
    }


}
