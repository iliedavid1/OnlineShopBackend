package com.store.backend.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashMap;

@AllArgsConstructor
@EqualsAndHashCode
@NoArgsConstructor
public class Cart {
    private HashMap<String ,CartProduct> cartProducts;

    public void deleteProductsFromCart() {
        this.cartProducts.clear();
    }

    public void addProductToCart(String productId, Integer quantity, Double price, String title) {
        if (this.cartProducts.containsKey(productId)) {
            this.cartProducts.get(productId).increaseQuantity(quantity);
            return;
        }
        this.cartProducts.put(productId, new CartProduct(productId, title, price, quantity));
    }

    public void removeProductFromCart(String productId, Integer quantity, Double price, String title) {
        this.cartProducts.get(productId).decreaseQuantity(quantity);
        if (this.cartProducts.get(productId).getQuantity() <= 0) {
            this.cartProducts.remove(productId);
        }
    }
}
