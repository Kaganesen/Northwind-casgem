package com.example.northwind.business.concretes;

import com.example.northwind.business.abstracts.CategoryService;
import com.example.northwind.business.abstracts.ProductService;
import com.example.northwind.business.requests.productRequest.CreateProductRequest;
import com.example.northwind.business.requests.productRequest.DeleteProductRequest;
import com.example.northwind.business.requests.productRequest.UpdateProductRequest;
import com.example.northwind.business.responses.productResponse.CreateProductResponse;
import com.example.northwind.business.responses.productResponse.DeleteProductResponse;
import com.example.northwind.business.responses.productResponse.GetAllProductResponse;
import com.example.northwind.business.responses.productResponse.UpdateProductResponse;
import com.example.northwind.core.utilities.mapping.ModelMapperService;
import com.example.northwind.dataAccess.abstracts.ProductRepository;
import com.example.northwind.entities.concretes.Category;
import com.example.northwind.entities.concretes.Product;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

//interfacelerin fakeleri uretilebilir . Classlarin fakeleri uretilmez. Unit test yaparken fake degerler atamamiz gerekir.
@Service
@AllArgsConstructor
public class ProductManager implements ProductService {

    ModelMapperService modelMapperService;
    ProductRepository productRepository;
    CategoryService categoryService;


    @Override
    public List<GetAllProductResponse> getAll() {
        List<Product> products = productRepository.findAll();
        List<GetAllProductResponse> getAllProductResponses = new ArrayList<>();

        for (Product product : products) {
            GetAllProductResponse responseItem = new GetAllProductResponse();
            responseItem.setId(product.getId());
            responseItem.setName(product.getName());
            responseItem.setUnitPrice(product.getUnitPrice());
            responseItem.setUnitsInStock(product.getUnitInStock());
            responseItem.setCategoryName(product.getCategory().getName());
            getAllProductResponses.add(responseItem);
        }
        return getAllProductResponses;
    }

    @Override
    public CreateProductResponse add(CreateProductRequest request) {
        Product product = this.modelMapperService.forRequest().map(request,Product.class);

        this.productRepository.save(product);
        CreateProductResponse createProductResponse = new CreateProductResponse();
        createProductResponse.setCategoryId(request.getCategoryId());
        createProductResponse.setName(request.getName());
        createProductResponse.setUnitsInStock(request.getUnitsInStock());
        createProductResponse.setUniPrice(request.getUniPrice());
        createProductResponse.setId(product.getId());

        return createProductResponse;
    }

    @Override
    public UpdateProductResponse update(UpdateProductRequest updateProductRequest) {
        UpdateProductResponse updateProductResponse = new UpdateProductResponse();

        Product product = productRepository.findById(updateProductRequest.getId()).get();
        product.setName(updateProductRequest.getName());
        product.setUnitPrice(updateProductRequest.getUniPrice());
        product.setUnitInStock(updateProductRequest.getUnitsInStock());

        Category category = new Category();
        category.setId(updateProductRequest.getCategoryId());
        product.setCategory(category);

        updateProductResponse.setId(updateProductRequest.getId());
        updateProductResponse.setName(updateProductRequest.getName());
        updateProductResponse.setCategoryId(product.getCategory().getId());
        updateProductResponse.setUnitPrice(updateProductRequest.getUniPrice());
        updateProductResponse.setUnitsInStock(updateProductRequest.getUnitsInStock());

        productRepository.save(product);


        return updateProductResponse;
    }

    @Override
    public DeleteProductResponse delete(DeleteProductRequest deleteProductRequest) {
        DeleteProductResponse deleteProductResponse = new DeleteProductResponse();
        Product product = productRepository.findById(deleteProductRequest.getId()).get();

        productRepository.deleteById(deleteProductRequest.getId());

        deleteProductResponse.setId(product.getId());
        deleteProductResponse.setName(product.getName());
        deleteProductResponse.setUnitPrice(product.getUnitPrice());
        deleteProductResponse.setUnitsInStock(product.getUnitInStock());
        deleteProductResponse.setCategoryName(product.getCategory().getName());


        return deleteProductResponse;
    }

    @Override
    public List<GetAllProductResponse> getByName(String name) {

        List<Product> products = productRepository.findByName(name);
        List<GetAllProductResponse> productsResponse = new ArrayList<>();

        for (Product product : products) {
            GetAllProductResponse responseItem = new GetAllProductResponse();
            responseItem.setName(product.getName());
            responseItem.setId(product.getId());
            responseItem.setCategoryName(product.getCategory().getName());
            responseItem.setUnitsInStock(product.getUnitInStock());
            responseItem.setUnitPrice(product.getUnitPrice());
            productsResponse.add(responseItem);

        }

        return productsResponse;
    }

    @Override
    public GetAllProductResponse getById(int id) {

        Product product = productRepository.findById(id).get();
        GetAllProductResponse productResponse = new GetAllProductResponse();
        productResponse.setId(product.getId());
        productResponse.setName(product.getName());
        productResponse.setCategoryName(product.getCategory().getName());
        productResponse.setUnitsInStock(product.getUnitInStock());
        productResponse.setUnitPrice(product.getUnitPrice());


        return productResponse;
    }


}

