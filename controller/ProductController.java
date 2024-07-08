package com.example.NativeQuerieswithSpringdataJpa.controller;

import com.example.NativeQuerieswithSpringdataJpa.entity.Product;
import com.example.NativeQuerieswithSpringdataJpa.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {


    @Autowired
    private ProductService productService;


    @PostMapping
    public void addProduct(@RequestParam String name, @RequestParam Double price) {
        productService.addProduct(name, price);
    }

    @GetMapping("/min-price")
    public Product getProductWithMinPrice() {
        return productService.getProductWithMinPrice();
    }

    @GetMapping("/max-price")
    public Product getProductWithMaxPrice() {
        return productService.getProductWithMaxPrice();
    }

    @GetMapping("/range")
    public List<Product> getProductsInRange(@RequestParam Double minPrice, @RequestParam Double maxPrice) {
        return productService.getProductsInRange(minPrice, maxPrice);
    }

}
