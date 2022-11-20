package com.example.northwind.business.abstracts;


import com.example.northwind.business.requests.orderRequest.CreateOrderRequest;
import com.example.northwind.business.requests.orderRequest.DeleteOrderRequest;
import com.example.northwind.business.requests.orderRequest.UpdateOrderRequest;
import com.example.northwind.business.responses.orderResponse.*;

import java.util.List;

public interface OrderService {



    List<GetAllOrderResponse> getAll();

    CreateOrderResponse add(CreateOrderRequest createOrderRequest);
    UpdateOrderResponse update(UpdateOrderRequest updateOrderRequest);
    DeleteOrderResponse delete(DeleteOrderRequest deleteOrderRequest);
    GetOrderResponse getById(int id);


}




