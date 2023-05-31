package com.store.backend.mapper;

import com.store.backend.dtos.LoginResponseDto;
import com.store.backend.model.Product;
import com.store.backend.model.User;
import com.store.backend.model.UserRole;

import java.util.ArrayList;
import java.util.List;

public class UserMapper {

    public static LoginResponseDto mapUserToLoginDto(User user) {
        LoginResponseDto dto = new LoginResponseDto();
        dto.setId(user.getId());
        dto.setName(user.getName());
        dto.setSurname(user.getSurname());
        dto.setEmail(user.getEmail());
        dto.setUserRole(user.getUserRole());
        dto.setCart(user.getCart());
        List<String> favoriteProducts = new ArrayList<>();
        for (Product product : user.getFavoriteProducts()) {
            favoriteProducts.add(product.getId());
        }
        dto.setFavoriteProducts(favoriteProducts);
        return dto;
    }
}
