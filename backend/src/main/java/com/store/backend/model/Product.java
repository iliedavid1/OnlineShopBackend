package com.store.backend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "product")
@Data
@AllArgsConstructor
@EqualsAndHashCode
@NoArgsConstructor
public class Product {
    @Id
    private String id;
    private String title;
    private String description;
    private Double price;
    private String imageUrl;
    private Double rating;
    private Integer nrReview;
}
