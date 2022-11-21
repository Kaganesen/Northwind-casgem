package com.example.northwind.business.responses.employeeResponse;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class GetAllEmployeeResponse {

    private int id;

    private String firstName;

    private String lastName;

    private double salary;
}
