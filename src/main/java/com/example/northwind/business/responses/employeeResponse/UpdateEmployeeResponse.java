package com.example.northwind.business.responses.employeeResponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class UpdateEmployeeResponse {

    private int id;
    private String name;

}
