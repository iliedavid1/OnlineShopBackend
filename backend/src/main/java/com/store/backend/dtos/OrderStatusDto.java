package com.store.backend.dtos;

import com.store.backend.model.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@EqualsAndHashCode
@NoArgsConstructor
@Data
public class OrderStatusDto {
    private String userId;
}
