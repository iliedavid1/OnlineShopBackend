package com.store.backend.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;

@AllArgsConstructor
@EqualsAndHashCode
@NoArgsConstructor
@Data
public class CartDto {
    private String userId;
    private String productId;
    private Integer quantity;
}
