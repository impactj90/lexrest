package de.assessment.lex.lexrest.service;

import de.assessment.lex.lexrest.dto.data.Product;

import javax.lang.model.element.ModuleElement;
import java.util.List;

public interface ProductService {
    List<Product> findAllProducts();
    Product findProductById(String id);
    Product findProductByEAN(String EAN);
    Product createProduct(Product product);
    Product updateProductById(String id, Product product);
    void deleteProductById(String id);
    void deleteAllProducts();
}
