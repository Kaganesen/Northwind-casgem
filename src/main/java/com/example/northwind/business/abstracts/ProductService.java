package com.example.northwind.business.abstracts;

import com.example.northwind.business.requests.productRequest.CreateProductRequest;
import com.example.northwind.business.responses.productResponse.CreateProductResponse;
import com.example.northwind.business.responses.productResponse.DeleteProductResponse;
import com.example.northwind.business.responses.productResponse.GetAllProductResponse;
import com.example.northwind.business.responses.productResponse.UpdateProductResponse;


import java.util.List;

public interface ProductService {

    List<GetAllProductResponse> getAll(); // Bizim verdigimiz yanittir. Bu yuzden response doner ve list seklinde olur.

    CreateProductResponse add(CreateProductRequest createProductRequest);  //Bize verilecek bir request datasidir.

    UpdateProductResponse update(UpdateProductResponse updateProductResponse);

    DeleteProductResponse delete(DeleteProductResponse deleteProductResponse);
    List<GetAllProductResponse> getByName(String name);

    GetAllProductResponse getById (int id);

}
