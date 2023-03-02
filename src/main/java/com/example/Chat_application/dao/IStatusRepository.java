package com.example.Chat_application.dao;


import com.example.Chat_application.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IStatusRepository extends JpaRepository<Status,Integer> {
}
