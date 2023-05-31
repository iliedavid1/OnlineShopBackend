package com.store.backend.controller;

import com.store.backend.dtos.CartDto;
import com.store.backend.model.Order;
import com.store.backend.service.CartService;
import com.store.backend.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public void addProductToCart(@RequestBody CartDto cartDto) {
        System.out.println("userID: " + cartDto.getUserId() + ", productID: " + cartDto.getProductId() + ", quantity: " + cartDto.getQuantity());
        service.addProductToCart(cartDto.getUserId(), cartDto.getProductId(), cartDto.getQuantity());
    }

    @PutMapping("/remove")
    public void removeProductFromCart(@RequestBody CartDto cartDto) {
        service.removeProductFromCart(cartDto.getUserId(), cartDto.getProductId(), cartDto.getQuantity());
    }

    @PostMapping("/placeOrder")
    public String placeOrder(@RequestBody Order order) {
        System.out.println("order: " + order);
        String ret = orderService.placeOrder(order);
        service.deleteProductsFromCart(order.getUserId());
        return ret;
    }
}
