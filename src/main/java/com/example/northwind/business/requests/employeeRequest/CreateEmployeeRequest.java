package com.example.northwind.business.requests.employeeRequest;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class CreateEmployeeRequest {


    private String firstName;

    private String lastName;

    private double salary;




}
