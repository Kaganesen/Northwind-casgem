package com.example.northwind.business.requests.orderRequest;

import com.example.northwind.entities.concretes.Employee;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class CreateOrderRequest {

    private LocalDateTime date;
    private Employee employee;


}
