package de.assessment.lex.lexrest.controller;

import de.assessment.lex.lexrest.dto.data.Product;
import de.assessment.lex.lexrest.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@CrossOrigin(origins = "${server.frontend.crossorigin}")
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<List<Product>> findAllProducts() {
        return ResponseEntity.ok().body(productService.findAllProducts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> findProductById(@PathVariable String id) {
        return ResponseEntity.ok().body(productService.findProductById(id));
    }

    @GetMapping("/ean/{EAN}")
    public ResponseEntity<Product> findProductByEAN(@PathVariable String EAN) {
        return ResponseEntity.ok().body(productService.findProductByEAN(EAN));
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        return ResponseEntity.ok().body(productService.createProduct(product));
    }

    @PutMapping
    public ResponseEntity<Product> updateProductById(String id, Product product) {
        return ResponseEntity.ok().body(productService.updateProductById(id, product));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProductById(String id) {
        productService.deleteProductById(id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping
    public ResponseEntity<?> deleteAllProducts() {
        productService.deleteAllProducts();
        return ResponseEntity.ok().build();
    }
}