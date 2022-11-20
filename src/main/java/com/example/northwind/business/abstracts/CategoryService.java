package com.example.northwind.business.abstracts;

import com.example.northwind.business.requests.categoryRequest.CreateCategoryRequest;
import com.example.northwind.business.requests.categoryRequest.DeleteCategoryRequest;
import com.example.northwind.business.requests.categoryRequest.UpdateCategoryRequest;
import com.example.northwind.business.responses.categoryResponse.CreateCategoryResponse;
import com.example.northwind.business.responses.categoryResponse.DeleteCategoryResponse;
import com.example.northwind.business.responses.categoryResponse.GetAllCategoryResponse;
import com.example.northwind.business.responses.categoryResponse.UpdateCategoryResponse;

import java.util.List;

public interface CategoryService {

    List<GetAllCategoryResponse> getAll();

    GetAllCategoryResponse getById(int id);


    //ICERISI HER ZAMAN REQUEST OLACAK
    CreateCategoryResponse add (CreateCategoryRequest createCategoryRequest);

    //ICERISI HER ZAMAN REQUEST OLACAK
    DeleteCategoryResponse delete(DeleteCategoryRequest deleteCategoryRequest);

    //ICERISI HER ZAMAN REQUEST OLACAK
    UpdateCategoryResponse update(UpdateCategoryRequest updateCategoryRequest);
}
