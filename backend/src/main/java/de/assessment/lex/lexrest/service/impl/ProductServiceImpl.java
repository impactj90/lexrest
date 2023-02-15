package de.assessment.lex.lexrest.service.impl;

import de.assessment.lex.lexrest.dto.data.Product;
import de.assessment.lex.lexrest.repository.ProductRepository;
import de.assessment.lex.lexrest.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> findAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product findProductById(String id) {
        return productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
    }

    @Override
    public Product findProductByEAN(String EAN) {
        return productRepository.findProductByEAN(EAN).orElseThrow(() -> new RuntimeException("EAN not found"));
    }

    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product updateProductById(String id, Product product) {
        productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
        return productRepository.save(product);
    }

    @Override
    public void deleteProductById(String id) {
        productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
        productRepository.deleteById(id);

    }

    @Override
    public void deleteAllProducts() {
        productRepository.deleteAll();
    }
}
