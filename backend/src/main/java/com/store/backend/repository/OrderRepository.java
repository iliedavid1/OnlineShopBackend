package com.store.backend.repository;

import com.store.backend.model.Order;
import com.store.backend.model.OrderStatus;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface OrderRepository extends MongoRepository<Order, String> {
    List<Order> findByUserId(String userId);
    List<Order> findByOrderStatus(OrderStatus status);
}
