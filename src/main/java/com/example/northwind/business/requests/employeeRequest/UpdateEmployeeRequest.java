package com.example.northwind.business.requests.employeeRequest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class UpdateEmployeeRequest {

    private int id;

    private String firstName;

    private String lastName;

    private double salary;
}
