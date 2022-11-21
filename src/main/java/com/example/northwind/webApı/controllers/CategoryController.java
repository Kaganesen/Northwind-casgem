package com.example.northwind.webApı.controllers;


import com.example.northwind.business.abstracts.CategoryService;
import com.example.northwind.business.requests.categoryRequest.CreateCategoryRequest;
import com.example.northwind.business.requests.categoryRequest.DeleteCategoryRequest;
import com.example.northwind.business.requests.categoryRequest.UpdateCategoryRequest;
import com.example.northwind.business.responses.categoryResponse.CreateCategoryResponse;
import com.example.northwind.business.responses.categoryResponse.DeleteCategoryResponse;
import com.example.northwind.business.responses.categoryResponse.GetAllCategoryResponse;
import com.example.northwind.business.responses.categoryResponse.UpdateCategoryResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
@AllArgsConstructor

public class CategoryController {

    CategoryService categoryService;

    @GetMapping("/getall")
    List<GetAllCategoryResponse> getAll(){
        return categoryService.getAll();
    }

    @GetMapping("/getbyid")
    GetAllCategoryResponse getById(int id){
        return categoryService.getById(id);
    }

    @PostMapping("/add")
    CreateCategoryResponse add (CreateCategoryRequest createCategoryRequest){
        return categoryService.add(createCategoryRequest);

    }
    @DeleteMapping("/delete")
    DeleteCategoryResponse delete(DeleteCategoryRequest deleteCategoryRequest){
        return categoryService.delete(deleteCategoryRequest);

    }
    @PutMapping("/update")
    UpdateCategoryResponse update(UpdateCategoryRequest updateCategoryRequest){
        return categoryService.update(updateCategoryRequest);

    }


}
