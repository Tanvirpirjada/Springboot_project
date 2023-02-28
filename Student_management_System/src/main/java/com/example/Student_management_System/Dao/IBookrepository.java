package com.example.Student_management_System.Dao;

import com.example.Student_management_System.Model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBookrepository extends JpaRepository<Book,Integer> {
}
