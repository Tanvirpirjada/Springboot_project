package com.example.Chat_application.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "status_tbl")
public class Status {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer status_id;

    private String status_name;

    private String status_description;
}
