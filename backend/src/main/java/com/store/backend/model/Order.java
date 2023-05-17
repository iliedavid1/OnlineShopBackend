package com.store.backend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "order")
@Data
@AllArgsConstructor
@EqualsAndHashCode
@NoArgsConstructor
public class Order {
    @Id
    private String id;
    private String userId;
    private Cart cart;
    private OrderStatus orderStatus;
}
