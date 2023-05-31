package com.store.backend.service;

import com.store.backend.model.Cart;
import com.store.backend.model.Product;
import com.store.backend.model.User;
import com.store.backend.repository.ProductRepository;
import com.store.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CartService {
    @Autowired
    private UserRepository repository;
    @Autowired
    private ProductRepository productRepository;

    public Cart getCartByUserId(String id) {
        return repository.findById(id).isEmpty() ? null : repository.findById(id).get().getCart();
    }

    public void deleteProductsFromCart(String id) {
        User user = repository.findById(id).get();
        Cart cart = user.getCart();
        cart.deleteProductsFromCart();
        repository.save(user);
    }

    public void addProductToCart(String id, String product, Integer quantity) {
        User user = repository.findById(id).get();
        Cart cart = user.getCart();
        Product product1 = productRepository.findById(product).get();
        cart.addProductToCart(product, quantity, product1.getPrice(), product1.getTitle());
        repository.save(user);
    }

    public void removeProductFromCart(String id, String productId, Integer quantity) {
        User user = repository.findById(id).get();
        Cart cart = user.getCart();
        Product product1 = productRepository.findById(productId).get();
        cart.removeProductFromCart(productId, quantity, product1.getPrice(), product1.getTitle());
        repository.save(user);
    }
}
