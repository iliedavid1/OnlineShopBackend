package com.store.backend.dtos;

import com.store.backend.model.UserRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@EqualsAndHashCode
@NoArgsConstructor
@Data
public class FavoriteDto {
    private String userId;
    private String productId;
}