package com.example.northwind.business.concretes;

import com.example.northwind.business.abstracts.EmployeeService;
import com.example.northwind.business.requests.employeeRequest.CreateEmployeeRequest;
import com.example.northwind.business.requests.employeeRequest.DeleteEmployeeRequest;
import com.example.northwind.business.requests.employeeRequest.UpdateEmployeeRequest;
import com.example.northwind.business.responses.employeeResponse.*;
import com.example.northwind.core.utilities.mapping.ModelMapperService;
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
    private ModelMapperService modelMapperService;


    @Override
    public List<GetAllEmployeeResponse> getAll() {
        List<Employee> employees = employeeRepository.findAll();
        List<GetAllEmployeeResponse> employeeResponses = new ArrayList<>();

        for (Employee employee : employees) {
            GetAllEmployeeResponse responseItem = new GetAllEmployeeResponse();
            responseItem.setFirstName(employee.getFirstName());
            responseItem.setLastName(employee.getLastName());
            responseItem.setSalary(employee.getSalary());
            responseItem.setId(employee.getId());
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
        Employee employee = this.modelMapperService.forRequest().map(createEmployeeRequest,Employee.class);
        this.employeeRepository.save(employee);
        CreateEmployeeResponse createEmployeeResponse = this.modelMapperService.forResponse().map(employee,CreateEmployeeResponse.class);
        return createEmployeeResponse;
    }

    @Override
    public UpdateEmployeeResponse update(UpdateEmployeeRequest updateEmployeeRequest) {
        Employee employee = this.modelMapperService.forRequest().map(updateEmployeeRequest,Employee.class);
        this.employeeRepository.save(employee);
        UpdateEmployeeResponse updateEmployeeResponse = this.modelMapperService.forResponse().map(employee,UpdateEmployeeResponse.class);
        return updateEmployeeResponse;

    }

    @Override
    public DeleteEmployeeResponse delete(DeleteEmployeeRequest deleteEmployeeRequest) {

        Employee employee = employeeRepository.findById(deleteEmployeeRequest.getId()).get();
        employeeRepository.delete(employee);
        DeleteEmployeeResponse deleteEmployeeResponse = new DeleteEmployeeResponse();

        deleteEmployeeResponse.setId(employee.getId());
        deleteEmployeeResponse.setFirstName(employee.getFirstName());
        deleteEmployeeResponse.setLastName(employee.getLastName());
        deleteEmployeeResponse.setSalary(employee.getSalary());


        return deleteEmployeeResponse;
    }


}
