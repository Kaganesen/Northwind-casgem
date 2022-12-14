package com.example.northwind.business.concretes;

import com.example.northwind.business.abstracts.CategoryService;
import com.example.northwind.business.requests.categoryRequest.CreateCategoryRequest;
import com.example.northwind.business.requests.categoryRequest.DeleteCategoryRequest;
import com.example.northwind.business.requests.categoryRequest.UpdateCategoryRequest;
import com.example.northwind.business.responses.categoryResponse.CreateCategoryResponse;
import com.example.northwind.business.responses.categoryResponse.DeleteCategoryResponse;
import com.example.northwind.business.responses.categoryResponse.GetAllCategoryResponse;
import com.example.northwind.business.responses.categoryResponse.UpdateCategoryResponse;
import com.example.northwind.core.utilities.mapping.ModelMapperService;
import com.example.northwind.dataAccess.abstracts.CategoryRepository;
import com.example.northwind.entities.concretes.Category;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class CategoryManager implements CategoryService {

    private CategoryRepository categoryRepository;
    private ModelMapperService modelMapperService;


    @Override
    public List<GetAllCategoryResponse> getAll() {
        List<Category> categories = categoryRepository.findAll();
        List<GetAllCategoryResponse> categoryResponses = new ArrayList<>();

        for (Category category : categories) {
            GetAllCategoryResponse responseItem = new GetAllCategoryResponse();
            responseItem.setId(category.getId());
            responseItem.setName(category.getName());
            categoryResponses.add(responseItem);
        }
        return categoryResponses;
    }

    @Override
    public GetAllCategoryResponse getById(int id) {
        Category category = categoryRepository.findById(id).get();
        GetAllCategoryResponse categoryResponse = new GetAllCategoryResponse();
        categoryResponse.setId(category.getId());
        categoryResponse.setName(category.getName());

        return categoryResponse;
    }

    @Override
    public CreateCategoryResponse add(CreateCategoryRequest createCategoryRequest) {
        Category category = this.modelMapperService.forRequest().map(createCategoryRequest, Category.class);
        this.categoryRepository.save(category);
        CreateCategoryResponse createCategoryResponse = this.modelMapperService.forResponse().map(category, CreateCategoryResponse.class);

        return createCategoryResponse;
    }

    @Override
    public DeleteCategoryResponse delete(DeleteCategoryRequest deleteCategoryRequest) {
        Category category = categoryRepository.findById(deleteCategoryRequest.getId()).get();
        categoryRepository.delete(category);
        DeleteCategoryResponse deleteCategoryResponse = new DeleteCategoryResponse();
        deleteCategoryResponse.setId(deleteCategoryRequest.getId());
        return deleteCategoryResponse;
    }

    @Override
    public UpdateCategoryResponse update(UpdateCategoryRequest updateCategoryRequest) {
        Category category =this.modelMapperService.forRequest().map(updateCategoryRequest , Category.class);
        this.categoryRepository.save(category);
        UpdateCategoryResponse updateCategoryResponse = this.modelMapperService.forResponse().map(category,UpdateCategoryResponse.class);
        return updateCategoryResponse;
    }


}
