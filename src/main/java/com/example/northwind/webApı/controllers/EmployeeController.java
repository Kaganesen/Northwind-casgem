package com.example.northwind.webApı.controllers;


import com.example.northwind.business.abstracts.EmployeeService;
import com.example.northwind.business.requests.employeeRequest.CreateEmployeeRequest;
import com.example.northwind.business.responses.employeeResponse.GetAllEmployeeResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    @GetMapping("/getall")
    public List<GetAllEmployeeResponse> getAll(){
        return employeeService.getAll();
    }

    public void add(CreateEmployeeRequest createEmployeeRequest){
        this.employeeService.add(createEmployeeRequest);
    }



}
