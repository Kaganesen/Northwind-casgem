package com.example.northwind.business.responses.productResponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class CreateProductResponse {

    private int id;
    private int categoryId;
    private String name;
    private double unitPrice;
    private int unitInStock;
}


