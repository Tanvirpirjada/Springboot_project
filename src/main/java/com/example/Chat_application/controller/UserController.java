package com.example.Chat_application.controller;


import com.example.Chat_application.dao.IStatusRepository;
import com.example.Chat_application.model.Status;
import com.example.Chat_application.model.Users;
import com.example.Chat_application.service.UsersService;
import com.example.Chat_application.validator.UserValidation;
import org.apache.catalina.User;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;

@RestController
public class UserController {

    @Autowired
    UsersService usersService;

    @Autowired
    UserValidation userValidation;

    @Autowired
    IStatusRepository statusRepository;




    @PostMapping("saveuser")
    public ResponseEntity saveuser(@RequestBody String user) throws Exception {
        JSONObject users=new JSONObject(user);
        JSONObject errros=userValidation.validateuser(users);
        if(errros.isEmpty()){
            Users newuser=setuser(users);
            usersService.saveuser(newuser);
        }
        else{
            return new ResponseEntity<>(errros.toString(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("user saved",HttpStatus.CREATED);
    }



    @GetMapping("getuser")
    public ResponseEntity getuser(@Nullable @RequestParam Integer user_id){
        JSONArray json=usersService.getuser(user_id);

        return new ResponseEntity<>(json.toString(),HttpStatus.OK);
    }

    @DeleteMapping("deleteuser/{user_id}")
    public ResponseEntity deleteuser(@PathVariable Integer user_id){
        int id=usersService.deleteuser(user_id);
    }
    private Users setuser(JSONObject json) {

        Users user=new Users();

        user.setUserName(json.getString("username"));
        user.setPassWord(json.getString("password"));
        user.setEmail(json.getString("email"));
        user.setPhoneNumber(json.getString("phoneNumber"));

        if(json.has("firstName")){
            user.setFirstName(json.getString("firstName"));
        }

        if(json.has("lastName")){
            user.setLastName(json.getString("lastName"));
        }

        if(json.has("age")){
            user.setAge(json.getInt("age"));
        }

        if(json.has("gender")){
            user.setGender(json.getString("gender"));
        }

        Timestamp createdDate=new Timestamp(System.currentTimeMillis());

        user.setCreatedDate(createdDate);


        Integer statusId= json.getInt("statusId");
        Status status=statusRepository.findById(statusId).get();
        user.setStatusId(status);

        return user;
    }


}
