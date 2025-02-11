package org.example.repo;

import org.example.entity.Suppliers;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SuppliersRepo extends MongoRepository<Suppliers, String> {
}
