package com.example.northwind.business.concretes;

import com.example.northwind.business.abstracts.OrderService;
import com.example.northwind.business.requests.orderRequest.CreateOrderRequest;
import com.example.northwind.business.requests.orderRequest.DeleteOrderRequest;
import com.example.northwind.business.requests.orderRequest.UpdateOrderRequest;
import com.example.northwind.business.responses.orderResponse.*;
import com.example.northwind.core.utilities.mapping.ModelMapperService;
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
    private ModelMapperService modelMapperService;


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
        Order order = this.modelMapperService.forRequest().map(createOrderRequest, Order.class);
        this.orderRepository.save(order);
        CreateOrderResponse createOrderResponse = this.modelMapperService.forResponse().map(order, CreateOrderResponse.class);

        return createOrderResponse;
    }


    @Override
    public UpdateOrderResponse update(UpdateOrderRequest updateOrderRequest) {
        Order order = this.modelMapperService.forRequest().map(updateOrderRequest, Order.class);
        this.orderRepository.save(order);
        UpdateOrderResponse updateOrderResponse = this.modelMapperService.forResponse().map(order, UpdateOrderResponse.class);

        return updateOrderResponse;
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
