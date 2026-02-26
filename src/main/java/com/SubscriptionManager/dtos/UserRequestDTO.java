package com.SubscriptionManager.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import java.util.UUID;

@Getter @Setter
public class UserRequestDTO {
    @NotBlank(message = "El nombre de usuario es obligatorio")
    private String username;

    @NotBlank(message = "La contraseña es obligatoria")
    @Size(min = 8, message = "La contraseña debe tener al menos 8 caracteres")
    private String password; // <-- ¡Añadido!

    @Email(message = "Email no válido")
    @NotBlank
    private String email;

    private UUID planId; // Recibimos solo el ID del plan seleccionado
}