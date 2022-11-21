package com.example.northwind.webApı.controllers;


import com.example.northwind.business.abstracts.EmployeeService;
import com.example.northwind.business.requests.employeeRequest.CreateEmployeeRequest;
import com.example.northwind.business.requests.employeeRequest.DeleteEmployeeRequest;
import com.example.northwind.business.requests.employeeRequest.UpdateEmployeeRequest;
import com.example.northwind.business.responses.employeeResponse.*;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    @GetMapping("/getall")
    public List<GetAllEmployeeResponse> getAll() {
        return employeeService.getAll();
    }

    @GetMapping("/getbyid")
    GetEmployeeResponse getById(int id) {
        return employeeService.getById(id);
    }

    @PostMapping("/add")
    CreateEmployeeResponse add(@RequestBody CreateEmployeeRequest createEmployeeRequest) {
        return employeeService.add(createEmployeeRequest);
    }

    @PutMapping("/update")
    UpdateEmployeeResponse update(UpdateEmployeeRequest updateEmployeeRequest) {
        return employeeService.update(updateEmployeeRequest);
    }

    @DeleteMapping("/delete")
    DeleteEmployeeResponse delete(DeleteEmployeeRequest deleteEmployeeRequest) {
        return employeeService.delete(deleteEmployeeRequest);
    }


}
