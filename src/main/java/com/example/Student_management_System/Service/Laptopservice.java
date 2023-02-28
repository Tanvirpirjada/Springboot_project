package com.example.Student_management_System.Service;

import com.example.Student_management_System.Dao.ILaptoprepository;
import com.example.Student_management_System.Dao.IStudentrepository;
import com.example.Student_management_System.Model.Laptop;
import com.example.Student_management_System.Model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class Laptopservice {

    @Autowired
    ILaptoprepository laptoprepository;

    @Autowired
    IStudentrepository studentrepository;


    public void sacvelaptop(Laptop laptop) {
        laptoprepository.save(laptop);
    }

    public List<Laptop> getleptop(Integer laptopId) {
        List<Laptop> laptops;
        if (laptopId != null) {
            laptops=new ArrayList<>();
            laptops.add(laptoprepository.findById(laptopId).get());
        }
        else{
            laptops=laptoprepository.findAll();
        }
    return laptops;
    }

    public void updatelaptop(Integer laptopId, Laptop newlaptop) {

        Laptop oldlaptop=laptoprepository.findById(laptopId).get();

        newlaptop.setLaptop_id(oldlaptop.getLaptop_id());

//        Student student=studentrepository.findById(oldlaptop.getStudent().getStudent_id()).get();
//
//        newlaptop.setStudent(student);

        laptoprepository.save(newlaptop);
    }

    public void deletelaptop(Integer laptopId) {
        Laptop laptop=laptoprepository.findById(laptopId).get();

        laptoprepository.delete(laptop);
    }
}
