package com.store.backend.service;

import com.store.backend.model.Product;
import com.store.backend.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;

    public Product addProduct(Product product) {
        product.setId(UUID.randomUUID().toString().split("-")[0]);
        product.setRating(0.0);
        product.setNrReview(0);
        return repository.save(product);
    }

    public List<Product> findAllProducts() {
        return repository.findAll();
    }

    public Product getProductById(String id) {
        return repository.findById(id).isEmpty() ? null : repository.findById(id).get();
    }

    public String deleteProduct(String id) {
        repository.deleteById(id);
        return "Product " + id + " deleted";
    }
}