package com.store.backend.controller;

import com.store.backend.model.Cart;
import com.store.backend.model.Order;
import com.store.backend.model.Product;
import com.store.backend.model.User;
import com.store.backend.service.CartService;
import com.store.backend.service.OrderService;
import com.store.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cart")
public class CartController {
    @Autowired
    private CartService service;
    @Autowired
    private OrderService orderService;

    @PutMapping("/add")
    public Cart addProductToCart(@RequestBody String userID, @RequestBody String productID, @RequestBody Integer quantity) {
        return service.addProductToCart(userID, productID, quantity);
    }

    @PutMapping("/remove")
    public Cart removeProductFromCart(@RequestBody String userID, @RequestBody String productID, @RequestBody Integer quantity) {
        return service.removeProductFromCart(userID, productID, quantity);
    }

    @PostMapping("/placeOrder/{id}")
    public void placeOrder(@RequestBody String id, @RequestBody Order order) {
        service.deleteProductsFromCart(id);
        orderService.placeOrder(order);
    }
}
