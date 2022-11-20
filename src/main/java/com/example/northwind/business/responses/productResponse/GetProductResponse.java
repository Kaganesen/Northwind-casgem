package com.example.northwind.business.responses.productResponse;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class GetProductResponse {

    private int id;
    private String name;
    private String categoryName;
    private int unitsInStock;
    private double unitPrice;

}
