package com.example.northwind.dataAccess.abstracts;


import com.example.northwind.entities.concretes.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order,Integer> {


}
