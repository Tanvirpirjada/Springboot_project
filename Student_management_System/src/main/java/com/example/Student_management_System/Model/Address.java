package com.example.Student_management_System.Model;

;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.persistence.Entity;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    private String landmark;
    private String zipcode;
    private String district;
    private String state;
    private String country;
}
