package com.example.Student_management_System.Service;

import com.example.Student_management_System.Dao.IStudentrepository;
import com.example.Student_management_System.Model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Studentservice {

    @Autowired
    IStudentrepository studentrepository;
    public void savestudent(Student student) {
        studentrepository.save(student);
    }

    public List<Student> getstudent(Integer studentId) {
        List<Student > students;
        if(studentId!=null){
            students=new ArrayList<>();
            students.add(studentrepository.findById(studentId).get());
        }
        else{
            students=studentrepository.findAll();
        }
        return  students;
    }

    public void updatestudent(Integer studentId,Student newstudent) {
        Student oldstudent=studentrepository.findById(studentId).get();

        newstudent.setStudent_id(oldstudent.getStudent_id());

        studentrepository.save(newstudent);
    }

    public void deletestudent(Integer studentId) {
        Student student=studentrepository.findById(studentId).get();
        studentrepository.delete(student);
    }
}
