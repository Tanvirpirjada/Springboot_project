package com.example.Chat_application.service;


import com.example.Chat_application.dao.IChatHistoryRepository;
import com.example.Chat_application.dao.IUserRepository;
import com.example.Chat_application.model.ChatHistory;
import com.example.Chat_application.model.Users;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatHistoryService {


    @Autowired
    IChatHistoryRepository chatHistoryRepository;


    @Autowired
    IUserRepository userRepository;
    public JSONObject seechats(int user1, int user2) {
        List<ChatHistory> chats= chatHistoryRepository.getConversation(user1,user2);
        List<Users> userone=userRepository.findByuserId(user1);
        List<Users> usertwo=userRepository.findByuserId(user2);
        JSONObject json=new JSONObject();
        if(userone.size()==0 || usertwo.size()==0){
            json.put("errorMessage","user is no longer Active");
        }

       if(!json.has("errorMessage")) {
           JSONArray jsonArray = new JSONArray();
           for (ChatHistory chatlist : chats) {
               JSONObject jsonObject = new JSONObject();
               jsonObject.put("created time", chatlist.getCreated_time());
               jsonObject.put("sender_name", chatlist.getFrom_user().getUserName());
               jsonObject.put("message", chatlist.getMassage());
               jsonArray.put(jsonObject);
           }

           json.put("conversation", jsonArray);

           return json;
       }
       else{
           return json;
       }
    }

    public void savechat(ChatHistory chat) {
         chatHistoryRepository.save(chat);
    }
}
