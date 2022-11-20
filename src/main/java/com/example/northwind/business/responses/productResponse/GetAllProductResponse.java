package com.example.northwind.business.responses.productResponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor


public class GetAllProductResponse {


    private int id;
    private String name;
    private String categoryName;
    private int unitsInStock;
    private double unitPrice;
}
