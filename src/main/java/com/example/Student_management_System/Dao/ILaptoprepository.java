package com.example.Student_management_System.Dao;

import com.example.Student_management_System.Model.Laptop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;


@Repository
public interface ILaptoprepository extends JpaRepository<Laptop,Integer> {
        }
