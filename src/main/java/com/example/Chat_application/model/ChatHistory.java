package com.example.Chat_application.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "chat_tbl")
public class ChatHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer chat_id;


    @JoinColumn(name = "receiverId")
    @OneToOne
    private Users to_user;

    @JoinColumn(name = "senderId")
    @OneToOne
    private Users from_user;

    private String massage;

    private Timestamp created_time;

    private Timestamp updated_date;

    @JoinColumn(name = "status_id")
    @ManyToOne
    private Status statusId;

}
