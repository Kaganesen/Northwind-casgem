package com.example.northwind.business.concretes;

import com.example.northwind.business.abstracts.EmployeeService;
import com.example.northwind.business.requests.employeeRequest.CreateEmployeeRequest;
import com.example.northwind.business.requests.employeeRequest.DeleteEmployeeRequest;
import com.example.northwind.business.requests.categoryRequest.UpdateCategoryRequest;
import com.example.northwind.business.responses.employeeResponse.*;
import com.example.northwind.dataAccess.abstracts.EmployeeRepository;
import com.example.northwind.entities.concretes.Employee;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class EmployeeManager implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;




    @Override
    public List<GetAllEmployeeResponse> getAll() {
        List<Employee> employees = employeeRepository.findAll();
        List<GetAllEmployeeResponse> employeeResponses = new ArrayList<>();

        for (Employee employee : employees){
            GetAllEmployeeResponse responseItem = new GetAllEmployeeResponse();
            responseItem.setFirstName(employee.getFirstName());
            responseItem.setLastName(employee.getLastName());
            responseItem.setSalary(employee.getSalary());
            employeeResponses.add(responseItem);

        }
        return employeeResponses;
    }

    @Override
    public GetEmployeeResponse getById(int id) {
        GetEmployeeResponse getEmployeeResponse = new GetEmployeeResponse();
        Employee employee = employeeRepository.findById(id).get();
        getEmployeeResponse.setId(employee.getId());
        getEmployeeResponse.setFirstName(employee.getFirstName());
        getEmployeeResponse.setLastName(employee.getLastName());
        getEmployeeResponse.setSalary(employee.getSalary());

        return getEmployeeResponse;
    }

    @Override
    public CreateEmployeeResponse add(CreateEmployeeRequest createEmployeeRequest) {
        CreateEmployeeResponse createEmployeeResponse = new CreateEmployeeResponse();
        Employee employee = new Employee();
        employee.setFirstName(createEmployeeRequest.getFirstName());
        employee.setLastName(createEmployeeRequest.getLastName());
        employee.setSalary(createEmployeeRequest.getSalary());
        createEmployeeResponse.setFirstName(createEmployeeRequest.getFirstName());
        createEmployeeResponse.setLastName(createEmployeeRequest.getLastName());
        createEmployeeResponse.setSalary(createEmployeeRequest.getSalary());

        return createEmployeeResponse;
    }

    @Override
    public UpdateEmployeeResponse update(UpdateCategoryRequest updateCategoryRequest) {


        return null;
    }

    @Override
    public DeleteEmployeeResponse delete(DeleteEmployeeRequest deleteEmployeeRequest) {

        return null;
    }


}
