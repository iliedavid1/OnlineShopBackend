package com.store.backend.controller;

import com.store.backend.dtos.DeliveredDto;
import com.store.backend.dtos.OrderStatusDto;
import com.store.backend.model.Order;
import com.store.backend.model.OrderStatus;
import com.store.backend.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order")
public class OrderController {
    @Autowired
    private OrderService service;

    @GetMapping("/user/{id}")
    public List<Order> getOrdersByUserId(@PathVariable String id) {
        return service.getOrdersByUserId(id);
    }

    @GetMapping("/status/{id}")
    public List<Order> getAllOrdersByStatus(@PathVariable String id) {
        return service.getAllOrdersByStatus(id);
    }

    @PostMapping("/delivered")
    public void orderDelivered(@RequestBody DeliveredDto deliveredDto) {
        service.orderDelivered(deliveredDto);
    }
}
