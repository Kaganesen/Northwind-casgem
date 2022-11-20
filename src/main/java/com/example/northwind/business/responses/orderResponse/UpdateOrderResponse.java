package com.example.northwind.business.responses.orderResponse;

import com.example.northwind.entities.concretes.Employee;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class UpdateOrderResponse {

    private int id;
    private LocalDateTime date;
    private Employee employeeId;
}
