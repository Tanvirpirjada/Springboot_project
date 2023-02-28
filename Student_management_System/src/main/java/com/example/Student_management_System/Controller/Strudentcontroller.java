package com.example.Student_management_System.Controller;


import com.example.Student_management_System.Model.Address;
import com.example.Student_management_System.Model.Student;
import com.example.Student_management_System.Service.Studentservice;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Strudentcontroller {

    @Autowired
    Studentservice studentservice;

    @PostMapping("savestudent")
    public ResponseEntity savestudent(@RequestBody String requeststudent){
        JSONObject studentdetails=new JSONObject(requeststudent);
        Student  student=setstudent(studentdetails);
        studentservice.savestudent(student);
        return new ResponseEntity<>("Student registered", HttpStatus.CREATED);
    }


    @GetMapping("getstudent")
    public List<Student> getstudent(@Nullable @RequestParam Integer student_id){
        List<Student> student=studentservice.getstudent(student_id);
        return student;
    }


    @PutMapping("updatestudent/{student_id}")
    public String updatestudent(@PathVariable Integer student_id  ,@RequestBody Student student ) {
        studentservice.updatestudent(student_id,student);
        return "student update";
    }

    @DeleteMapping("deletestudent")
    public String deletestudent(@RequestParam Integer student_id){
        studentservice.deletestudent(student_id);
        return "student deleted";
    }

    private Student setstudent(JSONObject json) {

        Student student=new Student();

        student.setName(json.getString("name"));
        student.setAge(json.getString("age"));
        student.setPhoneNumber(json.getString("phone_number"));
        student.setBranch(json.getString("branch"));
        student.setDepartment(json.getString("department"));
        JSONObject jsonObject=json.getJSONObject("address");
        Address address=new Address();
        address.setLandmark(jsonObject.getString("landmark"));
        address.setZipcode(jsonObject.getString("zipcode"));
        address.setDistrict(jsonObject.getString("district"));
        address.setState(jsonObject.getString("state"));
        address.setCountry(jsonObject.getString("country"));

        student.setAddress(address);
        return student;
    }
}
