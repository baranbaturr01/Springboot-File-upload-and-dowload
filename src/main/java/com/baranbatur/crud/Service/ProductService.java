package com.baranbatur.crud.Service;

import com.baranbatur.crud.Entities.ProductEntities;
import com.baranbatur.crud.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public List<ProductEntities> getAll() {
        return productRepository.findAll();
    }

    public ProductEntities addProduct(ProductEntities productEntities) {
        return productRepository.save(productEntities);
    }

    public ProductEntities getProductById(int id) {
        return productRepository.findById(id).orElse(null);
    }

    public void deleteProduct(int id){

    }
}
