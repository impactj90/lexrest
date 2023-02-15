package de.assessment.lex.lexrest.repository;

import de.assessment.lex.lexrest.dto.data.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ProductRepository extends MongoRepository<Product, String> {
    Optional<Product> findProductByEAN(String EAN);
}
