package com.store.backend.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@EqualsAndHashCode
@NoArgsConstructor
@Data
public class RegisterDto {
    private String name;
    private String surname;
    private String email;
    private String password;
}
