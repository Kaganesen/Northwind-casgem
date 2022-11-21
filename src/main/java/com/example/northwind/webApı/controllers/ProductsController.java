package com.example.northwind.webApı.controllers;

import com.example.northwind.business.abstracts.ProductService;
import com.example.northwind.business.requests.productRequest.CreateProductRequest;
import com.example.northwind.business.requests.productRequest.DeleteProductRequest;
import com.example.northwind.business.requests.productRequest.UpdateProductRequest;
import com.example.northwind.business.responses.productResponse.*;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/products")
public class ProductsController {

    ProductService productService;


    @GetMapping("/getall")
    List<GetAllProductResponse> getAllProductResponses() {
        return productService.getAll();
    }

    @PostMapping("/add")
    CreateProductResponse create(@RequestBody CreateProductRequest request) {
        return productService.add(request);
    }

    @DeleteMapping("/delete")
    DeleteProductResponse delete(@RequestBody DeleteProductRequest request) {
        return productService.delete(request);
    }

    @PutMapping("/update")
    UpdateProductResponse update(@RequestBody UpdateProductRequest request){
        return productService.update(request);
    }

    @GetMapping("/getbyid")
    GetAllProductResponse getById(int id){
        return productService.getById(id);
    }

    @GetMapping("/getbyname")
    List<GetAllProductResponse> getByName(String name){
        return productService.getByName(name);
    }


}
