package com.store.backend.mapper;

import com.store.backend.dtos.LoginResponseDto;
import com.store.backend.model.User;
import com.store.backend.model.UserRole;

public class UserMapper {

    public static LoginResponseDto mapUserToLoginDto(User user) {
        LoginResponseDto dto = new LoginResponseDto();
        dto.setName(user.getName());
        dto.setSurname(user.getSurname());
        dto.setEmail(user.getEmail());
        dto.setUserRole(user.getUserRole());
        user.setUserRole(UserRole.USER);
        return dto;
    }
}
