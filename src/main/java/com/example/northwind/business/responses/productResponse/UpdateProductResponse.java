package com.example.northwind.business.responses.productResponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class UpdateProductResponse {

    private int id;
    private String name;
    private int categoryId;
    private int unitsInStock;
    private double unitPrice;
}
