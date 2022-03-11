package com.example.companyemployeesspring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateEmployeeRequest {

    private int id;
    private String name;
    private String surname;
    private String email;
    private String phoneNumber;
    private double salary;
    private String position;
    private int companyId;
    private List<String> picNames;

}
