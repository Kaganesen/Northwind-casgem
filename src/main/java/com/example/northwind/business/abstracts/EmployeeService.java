package com.example.northwind.business.abstracts;

import com.example.northwind.business.requests.employeeRequest.CreateEmployeeRequest;
import com.example.northwind.business.requests.employeeRequest.DeleteEmployeeRequest;
import com.example.northwind.business.requests.categoryRequest.UpdateCategoryRequest;
import com.example.northwind.business.responses.employeeResponse.*;

import java.util.List;

public interface EmployeeService {
    List<GetAllEmployeeResponse> getAll();

    GetEmployeeResponse getById(int id);

    CreateEmployeeResponse add(CreateEmployeeRequest createEmployeeRequest);

    UpdateEmployeeResponse update(UpdateCategoryRequest updateCategoryRequest);

    DeleteEmployeeResponse delete(DeleteEmployeeRequest deleteEmployeeRequest);


}
