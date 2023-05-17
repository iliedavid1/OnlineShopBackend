package com.store.backend.service;

import com.store.backend.model.Order;
import com.store.backend.model.OrderStatus;
import com.store.backend.model.User;
import com.store.backend.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    OrderRepository repository;

    public void placeOrder(Order order) {
        order.setOrderStatus(OrderStatus.PENDING);
        repository.save(order);
    }

    public Order orderShipped(String orderId) {
        Order existingOrder = repository.findById(orderId).get();
        existingOrder.setOrderStatus(OrderStatus.SHIPPED);
        return repository.save(existingOrder);
    }

    public Order orderDelivered(String orderId) {
        Order existingOrder = repository.findById(orderId).get();
        existingOrder.setOrderStatus(OrderStatus.DELIVERED);
        return repository.save(existingOrder);
    }

    public List<Order> getOrdersByUserId(String userId) {
        return repository.findByUserId(userId);
    }

    public List<Order> getAllOrdersByStatus(OrderStatus status) {
        return repository.findByOrderStatus(status);
    }
}
