package com.example.northwind.webApı.controllers;


import com.example.northwind.business.abstracts.OrderService;
import com.example.northwind.business.requests.orderRequest.CreateOrderRequest;
import com.example.northwind.business.responses.orderResponse.CreateOrderResponse;
import com.example.northwind.business.responses.orderResponse.GetAllOrderResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/orders")
public class OrdersController {

    private OrderService orderService;


    @GetMapping("/getall")
    public List<GetAllOrderResponse> getALl(){
        return orderService.getAll();

    }
    @PostMapping("/add")
    CreateOrderResponse add(CreateOrderRequest createOrderRequest){
        return this.orderService.add(createOrderRequest);
    }
}
