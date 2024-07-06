package com.exemple.transferencia.DTO;

import com.exemple.transferencia.Entity.Enum.UserType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record UserDTO(
        @NotBlank
        String nome,
        @NotBlank
        String documento,
        @NotBlank
        String email,
        @NotBlank
        String password,

        @NotNull

        BigDecimal balanco,
        UserType userType
) {
}
