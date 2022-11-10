package com.baranbatur.crud.Controller;

import com.baranbatur.crud.Entities.ProductEntities;
import com.baranbatur.crud.Entities.ProductRequest;
import com.baranbatur.crud.Entities.ProductResponse;
import com.baranbatur.crud.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping(value = "/all", produces = "application/json")
    @ResponseBody
    public List<ProductResponse> getAll() {

        List<ProductEntities> productEntities = productService.getAll();
        List<ProductResponse> responseList = new ArrayList<>();

        for (ProductEntities product : productEntities) {
            ProductResponse response = new ProductResponse();
            response.setName(product.getName());
            response.setType(product.getType());
            response.setDescription(product.getDescription());
            response.setId(product.getId());
            responseList.add(response);
        }
        return responseList;
    }

    @PostMapping(value = "/add", produces = "application/json")
    public ProductEntities addProduct(@RequestBody ProductRequest productRequest) {

        ProductEntities productEntities = new ProductEntities();
        productEntities.setName(productRequest.getName());
        productEntities.setType(productRequest.getType());
        productEntities.setPrice(productRequest.getPrice());
        productEntities.setStock(productRequest.getStock());
        productEntities.setDescription(productRequest.getDescription());

        return productService.addProduct(productEntities);
    }

    @PostMapping(value = "/delete/{id}", produces = "application/json")
    public String deleteProduct(@PathVariable int id) {
        ProductEntities productEntities = productService.getProductById(id);
        if (productEntities == null) {
            return "Product not found";
        } else {
            productService.deleteProduct(id);
            return "Product deleted";
        }
    }
}
