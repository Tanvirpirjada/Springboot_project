package com.example.Student_management_System.Controller;


import com.example.Student_management_System.Dao.IStudentrepository;
import com.example.Student_management_System.Model.Laptop;
import com.example.Student_management_System.Model.Student;
import com.example.Student_management_System.Service.Laptopservice;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNullApi;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Laptopcontroller {

    @Autowired
    Laptopservice laptopservice;

    @Autowired
    IStudentrepository studentrepository;


    @PostMapping("savelaptop")
    public ResponseEntity savelaptop(@RequestBody String laptop){
        JSONObject laptopdetails=new JSONObject(laptop);
        Laptop newlaptop=setlaptop(laptopdetails);
        laptopservice.sacvelaptop(newlaptop);
        return new ResponseEntity<>("laptop save", HttpStatus.CREATED);
    }


    @GetMapping("getlaptop")
    public List<Laptop> getleptop(@Nullable @RequestParam Integer laptop_id){
        List<Laptop>laptops=laptopservice.getleptop(laptop_id);
        return  laptops;
    }

    @PutMapping("updatelaptop/{laptop_id}")
    public String updatelaptop(@PathVariable Integer laptop_id,@RequestBody  Laptop newlaptop){
        laptopservice.updatelaptop(laptop_id,newlaptop);
        return "laptop uodated";
    }


    @DeleteMapping("deletelaptop")
    public String deletelaptop(@RequestParam Integer laptop_id){
         laptopservice.deletelaptop(laptop_id);

        return "laptop delete successfully";
    }
    private Laptop setlaptop(JSONObject json) {
        Laptop laptop=new Laptop();

        laptop.setName(json.getString("name"));
        laptop.setBrand(json.getString("brand"));
        laptop.setPrice(json.getInt("price"));

        Integer student_id= json.getInt("student_id");
        Student student=studentrepository.findById(student_id).get();
         laptop.setStudent(student);
        return laptop;
    }
}


