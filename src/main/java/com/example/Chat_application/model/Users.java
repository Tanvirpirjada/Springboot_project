package com.example.Chat_application.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.sql.Timestamp;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user_tbl")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer userId;
    @Column(name = "user_name")

    private String userName;
    @Column(name = "password")

    private String passWord;
    @Column(name = "email")

    private String email;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "first_name")

    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "created_date")
    private Timestamp createdDate;
    @Column(name = "updated_dater")
    private Timestamp updatedDate;
    @Column(name = "age")
    private Integer age;


    @Column(name = "gender")
    private String gender;


    @JoinColumn(name = "status_id")
    @OneToOne(fetch = FetchType.LAZY)
    private Status statusId;

}
