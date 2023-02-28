package com.example.Student_management_System.Service;

import com.example.Student_management_System.Dao.ICourserepository;
import com.example.Student_management_System.Dao.IStudentrepository;
import com.example.Student_management_System.Model.Course;
import com.example.Student_management_System.Model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Courseservice {

    @Autowired
    ICourserepository courserepository;

    @Autowired
    IStudentrepository studentrepository;
    public void savecourse(Course course) {

        courserepository.save(course);
    }

    public List<Course> getcourse(Integer courseId) {
        List<Course>courses;
        if(courseId!=null){
            courses=new ArrayList<>();
            courses.add(courserepository.findById(courseId).get());
        }
        else{
            courses=courserepository.findAll();

        }
        return  courses;
    }

    public void updatecourse(Integer courseId, Course newcourse) {
        Course oldcourse=courserepository.findById(courseId).get();

        newcourse.setCourse_id(oldcourse.getCourse_id());

        courserepository.save(newcourse);
    }
}
