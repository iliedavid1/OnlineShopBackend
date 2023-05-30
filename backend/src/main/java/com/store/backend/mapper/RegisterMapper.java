package com.store.backend.mapper;

import com.store.backend.dtos.RegisterDto;
import com.store.backend.model.Cart;
import com.store.backend.model.User;
import com.store.backend.model.UserRole;

import java.util.ArrayList;

public class RegisterMapper {

    public static User mapRegisterDtoToUser(RegisterDto registerDto) {
        User user = new User();
        user.setName(registerDto.getName());
        user.setSurname(registerDto.getSurname());
        user.setEmail(registerDto.getEmail());
        user.setPassword(registerDto.getPassword());
        user.setUserRole(UserRole.USER);
        user.setCart(new Cart());
        user.setFavoriteProducts(new ArrayList<>());
        user.setReviews(new ArrayList<>());
        return user;
    }
}
