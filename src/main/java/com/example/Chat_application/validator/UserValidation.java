package com.example.Chat_application.validator;


import com.example.Chat_application.dao.IUserRepository;
import com.example.Chat_application.model.Users;
import com.example.Chat_application.utils.UserUtil;
import org.apache.catalina.User;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import java.util.List;


@Component
public class UserValidation {
    @Autowired
    IUserRepository userRepository;

    @Autowired
      UserUtil userUtil;
    public  JSONObject  validateuser(JSONObject json)  {
        JSONObject errorList=new JSONObject();


        //UserName_validation
        if(json.has("username")) {
            String username = json.getString("username");
            List<Users> user=userRepository.findByUserName(username);
            if(!user.isEmpty()){
                errorList.put("username","Already exists");
            }

        }


        else{
             errorList.put("username","username must be mandatory");
        }

        //password-validation
        if(json.has("password")){
            String password= json.getString("password");
             if(!userUtil.isValidPassword(password)){
                 errorList.put("password","it contains at least 8 characters and at most 20 characters.\n" +
                         "It contains at least one digit.\n" +
                         "It contains at least one upper case alphabet.\n" +
                         "It contains at least one lower case alphabet.\n" +
                         "It contains at least one special character which includes !@#$%&*()-+=^.\n" +
                         "It doesn’t contain any white space.");
             }
        }

        else{
          errorList.put("password","password must be not blank");
        }


       //email_validation
        if(json.has("email")){
            String email= json.getString("email");
              if(!userUtil.isValid(email)) {
                  errorList.put("email", "need valid email eg: tanvir@gmail.com");
              }
        }

        else{
          errorList.put("email","Must Be not Blank");
        }


        //phoneNumber_validation
        if(json.has("phoneNumber")) {
            String phoneNumber = json.getString("phoneNumber");
            if (!userUtil.isPhoneNumberValid(phoneNumber)) {
                errorList.put("phoneNumber", "The first digit should contain numbers between 6 to 9.\n" +
                        "The rest 9 digit can contain any number between 0 to 9.\n" +
                        "The mobile number can have 11 digits also by including 0 at the starting.\n" +
                        "The mobile number can be of 12 digits also by including 91 at the starting");
            }
        }

        else{
            errorList.put("phoneNumber","Number is Mandatory");
           }


        return errorList;
    }
}
