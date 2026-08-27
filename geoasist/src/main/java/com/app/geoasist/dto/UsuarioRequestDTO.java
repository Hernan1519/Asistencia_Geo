package com.app.geoasist.dto;

import jakarta.validation.constraints.*;

import java.time.LocalDate;

public record UsuarioRequestDTO(

        @NotBlank(message = "El nombre no debe estar vacio")
        @Size(min=2,max = 30, message = "El nombre debe tener entre 2 a 30 caracteres")
        String nombre,

        @NotBlank(message = "El apellido no puede estar vacio")
        @Size(min = 2, max = 30, message = "El apellido debe tener entre 2 y 30 caracteres")
        String apellido,

        @NotNull(message = "La fecha de nacimiento es obligatoria")
        @Past(message = "La fecha de nacimiento debe ser en el pasado")
        LocalDate fechaNacimiento,

        @NotNull(message = "El dni es obligatorio")
        @Positive(message = "El dni debe ser positivo")
        Long dni,

        @NotBlank(message = "El mail no debe estar vacio")
        @Email(message = "Formato de email no valido")
        String email,

        @NotBlank(message = "La contraseña no puede estar vacia ")
        @Size(min = 6,max = 100,message = "Minimo de contraseña 6 caracteres")
        String password,

        @NotNull(message = "Debe asignar un Rol al usuario")
        Integer idRol,

        @NotNull(message = "El legajo es obligatorio")
        @Positive(message = "El legajo debe ser positivo")
        Integer legajo,

        @NotBlank(message = "El sector es obligatorio")
        @Size(max = 50, message = "El sector no puede superar los 50 caracteres")
        String sector,

        Long idSupervisor

) {}
