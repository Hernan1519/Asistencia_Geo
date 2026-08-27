package com.app.geoasist.dto;

public record UsuarioResponseDTO(
        Long idUsuario,
        String nombre,
        String apellido,
        Long dni,
        String email
) {}