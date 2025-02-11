package org.example.repo;

import org.example.entity.Products;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductsRepo extends MongoRepository<Products, String>{
}
