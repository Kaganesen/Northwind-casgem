package com.example.northwind.business.responses.orderResponse;

import com.example.northwind.entities.concretes.Employee;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class GetOrderResponse {

    private int id;
    private LocalDateTime date;
    private int employee;

}
