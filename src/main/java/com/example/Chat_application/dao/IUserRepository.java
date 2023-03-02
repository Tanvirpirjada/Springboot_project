package com.example.Chat_application.dao;


import com.example.Chat_application.model.Status;
import com.example.Chat_application.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUserRepository extends JpaRepository<Users,Integer> {

    // select * from  user where username=name;

    @Query(value = "select * from user_tbl where user_name= :name and status_id = 1",nativeQuery = true)
     public List<Users> findByUserName(String name);

    @Query(value = "select * from user_tbl where status_id=1",nativeQuery = true)
    public List<Users> findUsers();


}
