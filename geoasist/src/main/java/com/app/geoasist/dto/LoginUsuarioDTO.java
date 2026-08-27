package com.app.geoasist.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record LoginUsuarioDTO(
        @NotBlank(message = "El main no puede estar vacio")
        @Email(message = "Formato incorrecto de Mail")
        String email,
        @NotBlank(message = "No puede estar vacio la contraseña")
        @Size(min = 6,max = 100,message = "Rango minimo 6 caracteres")
        String password
) {
}
