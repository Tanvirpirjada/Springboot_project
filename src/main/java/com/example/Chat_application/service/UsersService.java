package com.example.Chat_application.service;


import com.example.Chat_application.dao.IUserRepository;
import com.example.Chat_application.model.Users;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsersService {

    @Autowired
    IUserRepository userRepository;


    public void saveuser(Users newuser) {
        userRepository.save(newuser);
    }

    public JSONArray getuser(Integer userId) {
        JSONArray usersdetaails;
        List<Users> user;
        if(userId!=null){
            user=new ArrayList<>();
            user.add(userRepository.findById(userId).get());
            usersdetaails=setuser(user);
        }
        else{
          user=userRepository.findAll();
          usersdetaails=setuser(user);
        }
        return usersdetaails;
    }

    private JSONArray setuser(List<Users> user) {

        JSONArray jsonArray=new JSONArray();

        for(Users users: user){
            JSONObject json= new JSONObject();
            json.put("username",users.getUserName());
            json.put("email",users.getEmail());
            json.put("firstName",users.getFirstName());
            json.put("lastName",users.getLastName());
            json.put("created_date",users.getCreatedDate());
            json.put("age",users.getAge());
            json.put("gender",users.getGender());
            jsonArray.put(json);
        }
        return jsonArray;
    }

//    public int deleteuser(Integer userId) {
//
//        Users users=userRepository.findById(userId).get();
//        Status status=n
//        users.setStatusId();
//
//    }
}
