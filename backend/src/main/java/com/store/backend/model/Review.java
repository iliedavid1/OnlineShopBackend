package com.store.backend.model;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Review {
    private String userId;
    private String productId;
    private Integer rating;
    private String description;
}
