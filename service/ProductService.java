package com.example.NativeQuerieswithSpringdataJpa.service;

import com.example.NativeQuerieswithSpringdataJpa.entity.Product;
import com.example.NativeQuerieswithSpringdataJpa.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public void addProduct(String name, Double price) {
        productRepository.addProduct(name, price);
    }

    public Product getProductWithMinPrice() {
        return productRepository.findProductWithMinPrice();
    }

    public Product getProductWithMaxPrice() {
        return productRepository.findProductWithMaxPrice();
    }

    public List<Product> getProductsInRange(Double minPrice, Double maxPrice) {
        return productRepository.findProductsInRange(minPrice, maxPrice);
    }
}

