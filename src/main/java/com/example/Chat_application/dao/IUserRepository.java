package com.example.Chat_application.dao;


import com.example.Chat_application.model.Status;
import com.example.Chat_application.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface IUserRepository extends JpaRepository<Users,Integer> {

    // select * from  user where username=name;

    @Query(value = "select * from user_tbl where user_name= :name and status_id = 1",nativeQuery = true)
     public List<Users> findByUserName(String name);

    @Query(value = "select * from user_tbl where user_id= :userId and status_id=1",nativeQuery = true)
    public List<Users> findByuserId(Integer userId);


    @Query(value = "select * from user_tbl where status_id=1",nativeQuery = true)
    public List<Users> findAlluser();

    @Modifying //its enhanc the queary annotation so that we can use update delete also
    @Transactional
    @Query(value = "update user_tbl set status_id=2 where user_id= :userId",countQuery = "select count(*) form user_tbl",nativeQuery = true)
    public void deleteuserById(Integer userId);

      /*
    * Use this method if the spring version is lower/upper than 3.0.3
    @Query(value = "update tbl_user set status_id = 2 where user_id = :userId", nativeQuery = true)
    public void deleteUserByUserId(int userId);
    @Query(value = "update Users set statusId = 2 where userId = :userId")
    public void deleteUserByUserId(int userId);
    * */

}
