package com.example.northwind.business.concretes;

import com.example.northwind.business.abstracts.OrderService;
import com.example.northwind.business.requests.orderRequest.CreateOrderRequest;
import com.example.northwind.business.requests.orderRequest.DeleteOrderRequest;
import com.example.northwind.business.requests.orderRequest.UpdateOrderRequest;
import com.example.northwind.business.responses.orderResponse.*;
import com.example.northwind.dataAccess.abstracts.OrderRepository;
import com.example.northwind.entities.concretes.Order;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class OrderManager implements OrderService {
    @Autowired

    private OrderRepository orderRepository;


    @Override
    public List<GetAllOrderResponse> getAll() {
        List<GetAllOrderResponse> orderResponses = new ArrayList<>();
        List<Order> orders = orderRepository.findAll();

        for (Order order : orders) {
            GetAllOrderResponse responseItem = new GetAllOrderResponse();
            responseItem.setDate(order.getDate());
            responseItem.setEmployeeId(order.getEmployee());
            orderResponses.add(responseItem);
        }
        return orderResponses;
    }

    @Override
    public CreateOrderResponse add(CreateOrderRequest createOrderRequest) {
        CreateOrderResponse createOrderResponse = new CreateOrderResponse();
        Order order = new Order();
        order.setDate(createOrderRequest.getDate());
        order.setEmployee(createOrderRequest.getEmployee());

        createOrderResponse.setEmployeeId(order.getEmployee().getId());
        createOrderResponse.setDate(order.getDate());
        createOrderResponse.setId(order.getId());

        orderRepository.save(order);

        return createOrderResponse;
    }


    @Override
    public UpdateOrderResponse update(UpdateOrderRequest updateOrderRequest) {
        UpdateOrderResponse updateOrderResponse = new UpdateOrderResponse();
        Order order = orderRepository.findById(updateOrderResponse.getId()).get();

        return null;
    }

    @Override
    public DeleteOrderResponse delete(DeleteOrderRequest deleteOrderRequest) {
        return null;
    }

    @Override
    public GetOrderResponse getById(int id) {
        return null;
    }
}
