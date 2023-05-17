package com.store.backend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "user")
@Data
@AllArgsConstructor
@EqualsAndHashCode
@NoArgsConstructor
public class User {
    @Id
    private String id;
    private String name;
    private String surname;
    private String email;
    private String password;
    private UserRole userRole;
    private Cart cart;
    private List<Product> favoriteProducts;
    private List<Review> reviews;
}
