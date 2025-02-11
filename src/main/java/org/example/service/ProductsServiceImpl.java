package org.example.service;

import org.example.entity.Products;
import org.example.repo.ProductsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductsServiceImpl implements ProductsService{

    @Autowired
    private ProductsRepo productsRepo;

    @Override
    public Products addProduct(Products product) {
        if (product == null) {
            return null;
        } else {
            product.setProductId(UUID.randomUUID().toString());
            productsRepo.save(product);
            return product;
        }
    }

    @Override
    public Products getProductById(String productId) {
        return productsRepo.findById(productId).orElse(null);
    }

    @Override
    public List<Products> getAllProducts() {
        return productsRepo.findAll();
    }

    @Override
    public Products updateProduct(String productId, Products product) {
        Optional<Products> products = productsRepo.findById(productId);
        if(products.isPresent()){
            Products products1 = products.get();
            products1.setProductName(product.getProductName());
            products1.setProductPrice(product.getProductPrice());
            products1.setProductQuantity(product.getProductQuantity());
            products1.setProductCategory(product.getProductCategory());
            products1.setProductDescription(product.getProductDescription());
            System.out.println("Product " + products1.getProductId() + " is updated");
            return productsRepo.save(products1);
        }
        else{
            System.out.println("Supplier not found");
            return null;
        }
    }

    @Override
    public void deleteProduct(String productId) {
        if(productsRepo.findById(productId).isPresent()){
            productsRepo.deleteById(productId);
            System.out.println("Product " + productId + " is deleted");
        }
        else{
            System.out.println("Product not found");
        }
    }
}
