package com.store.backend.controller;

import com.store.backend.model.Order;
import com.store.backend.model.OrderStatus;
import com.store.backend.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/order")
public class OrderController {
    @Autowired
    private OrderService service;

    @GetMapping("/user/{id}")
    public void getOrdersByUserId(String id) {
        service.getOrdersByUserId(id);
    }

    @GetMapping("/{status}")
    public void getAllOrdersByStatus(OrderStatus status) {
        service.getAllOrdersByStatus(status);
    }

    @PostMapping("/shipped/{id}")
    public void orderShipped(@RequestBody String id) {
        service.orderShipped(id);
    }

    @PostMapping("/delivered/{id}")
    public void orderDelivered(@RequestBody String id) {
        service.orderDelivered(id);
    }
}
