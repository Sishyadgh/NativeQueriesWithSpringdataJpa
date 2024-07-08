package com.example.NativeQuerieswithSpringdataJpa.repo;

import com.example.NativeQuerieswithSpringdataJpa.entity.Product;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    // Method to add a product (save is provided by CrudRepository) but use our
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO products (name, price) VALUES (:name, :price)", nativeQuery = true)
    void addProduct(@Param("name") String name, @Param("price") Double price);


    // Method to get the product with the minimum price
    @Query(value = "SELECT * FROM products ORDER BY price ASC LIMIT 1", nativeQuery = true)
    Product findProductWithMinPrice();

    // Method to get the product with the maximum price
    @Query(value = "SELECT * FROM products ORDER BY price DESC LIMIT 1", nativeQuery = true)
    Product findProductWithMaxPrice();

    // Method to get products within a price range
    @Query(value = "SELECT * FROM products WHERE price BETWEEN :minPrice AND :maxPrice", nativeQuery = true)
    List<Product> findProductsInRange(@Param("minPrice") Double minPrice, @Param("maxPrice") Double maxPrice);
}




