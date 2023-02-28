package com.example.Student_management_System.Dao;

import com.example.Student_management_System.Model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICourserepository  extends JpaRepository<Course,Integer> {
}
