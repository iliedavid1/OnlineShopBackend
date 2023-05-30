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
public class LoginResponseDto {
    private String id;
    private String name;
    private String surname;
    private String email;
    private UserRole userRole;
}

