package com.store.backend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "review")
@Data
@EqualsAndHashCode
@AllArgsConstructor
public class Review {
    private String productId;
    private Integer rating;
//    private String description;
}
