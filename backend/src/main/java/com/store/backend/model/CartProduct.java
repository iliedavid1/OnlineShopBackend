package com.store.backend.model;

import lombok.*;

@AllArgsConstructor
@EqualsAndHashCode
@NoArgsConstructor
@Getter
@Setter
public class CartProduct {
    private String productId;
    private String title;
    private Double price;
    private Integer quantity;

    public void increaseQuantity(Integer quantity) {
        this.quantity += quantity;
    }
    public void decreaseQuantity(Integer quantity) {
        this.quantity -= quantity;
    }
}
