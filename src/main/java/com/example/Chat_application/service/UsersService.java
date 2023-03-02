package com.example.Chat_application.service;


import com.example.Chat_application.dao.IUserRepository;
import com.example.Chat_application.model.Users;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
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
            user=(userRepository.findByuserId(userId));
            usersdetaails=setuser(user);
        }
        else{
          user=userRepository.findAlluser();
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

    public JSONObject login(String username, String password) {
        List<Users> usersList=userRepository.findByUserName(username);
        JSONObject json=new JSONObject();
        if(!usersList.isEmpty()){
           Users user= usersList.get(0);
           if(user.getPassWord().equals(password)){
               json=setuser(usersList).getJSONObject(0);
           }
           else{

               json.put("errorMassage","Password is Wrong");
           }
        }
        else{
            json.put("errorMassage","username is not exists");
        }
        return json;
    }


    public JSONObject updateuser(Integer userId, Users newuser) {
          JSONObject json=new JSONObject();
        List<Users> usersList=userRepository.findByuserId(userId);
        if(!usersList.isEmpty()) {
            Users olduser=usersList.get(0);
            newuser.setUserId(olduser.getUserId());
           Timestamp updated_Date=new Timestamp(System.currentTimeMillis());
           newuser.setUpdatedDate(updated_Date);
            newuser.setPassWord(olduser.getPassWord());
            Timestamp updatedDate = new Timestamp(System.currentTimeMillis());

            newuser.setUpdatedDate(updatedDate);

            userRepository.save(newuser);
        }
        else {
            json.put("errorMassage", "user does not exists");
        }


return json;
    }

    public void deleteuser(Integer userId) {
        userRepository.deleteuserById(userId);
    }
}


