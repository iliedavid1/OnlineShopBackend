package com.store.backend.service;

import com.store.backend.dtos.DeliveredDto;
import com.store.backend.model.*;
import com.store.backend.repository.OrderRepository;
import com.store.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class OrderService {
    @Autowired
    OrderRepository repository;

    @Autowired
    UserRepository userRepository;

    public String placeOrder(Order order) {
        order.setId(UUID.randomUUID().toString().split("-")[0]);
        Cart cart = userRepository.findById(order.getUserId()).get().getCart();
        order.setCart(cart);
        order.setOrderStatus(OrderStatus.PENDING);
        repository.save(order);
        return order.getId();
    }

    public void orderDelivered(DeliveredDto deliveredDto) {
        User user = userRepository.findById(deliveredDto.getUserId()).get();
        if (user.getUserRole().equals(UserRole.ADMIN)) {
            Order existingOrder = repository.findById(deliveredDto.getOrderId()).get();
            existingOrder.setOrderStatus(OrderStatus.DELIVERED);
            repository.save(existingOrder);
        }
    }

    public List<Order> getOrdersByUserId(String userId) {
        return repository.findByUserId(userId);
    }

    public List<Order> getAllOrdersByStatus(String id) {
        User user = userRepository.findById(id).get();
        if (user.getUserRole().equals(UserRole.ADMIN)) {
            return repository.findAll();
        }
        return null;
    }
}
