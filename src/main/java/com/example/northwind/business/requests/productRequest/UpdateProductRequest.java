package com.example.northwind.business.requests.productRequest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class UpdateProductRequest {

    private int id;

    private int categoryId;

    private String name;

    private double uniPrice;

    private int unitsInStock;
}
