package com.example.northwind.business.requests.categoryRequest;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class UpdateCategoryRequest {

    private int id;
    private String name;
}
