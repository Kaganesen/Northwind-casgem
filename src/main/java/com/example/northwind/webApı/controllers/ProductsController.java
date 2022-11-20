package com.example.northwind.webApı.controllers;

import com.example.northwind.business.abstracts.ProductService;
import com.example.northwind.business.requests.productRequest.CreateProductRequest;
import com.example.northwind.business.responses.productResponse.CreateProductResponse;
import com.example.northwind.business.responses.productResponse.GetAllProductResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/products")
public class ProductsController {

    ProductService productService;


    @GetMapping("/getall")
    List<GetAllProductResponse> getAllProductResponses(){
        return productService.getAll();
    }

    @PostMapping("/add")
    CreateProductResponse create(@RequestBody CreateProductRequest request){
        return productService.add(request);
    }




}
