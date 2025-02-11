package org.example.service;

import org.example.entity.Products;

import java.util.List;

public interface ProductsService {

    Products addProduct(Products product);
    Products getProductById(String productId);
    List<Products> getAllProducts();
    Products updateProduct(String productId, Products product);
    void deleteProduct(String productId);
}
