package com.store.backend.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "user")
@Data
@AllArgsConstructor
@EqualsAndHashCode
@NoArgsConstructor
@Setter
@Getter
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
