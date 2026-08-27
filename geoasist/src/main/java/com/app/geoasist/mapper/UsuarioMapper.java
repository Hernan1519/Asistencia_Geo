package com.app.geoasist.mapper;

import com.app.geoasist.dto.UsuarioRequestDTO;
import com.app.geoasist.dto.UsuarioResponseDTO;
import com.app.geoasist.model.Empleados;
import com.app.geoasist.model.Usuario;

public class UsuarioMapper {
    public static Usuario toEntity(UsuarioRequestDTO dto) {
        if (dto == null) {
            return null;
        }

        return Usuario.builder()
                .nombre(dto.nombre())
                .apellido(dto.apellido())
                .fechaNacimiento(dto.fechaNacimiento())
                .dni(dto.dni())
                .email(dto.email())
                .build();

    }
    public static  Empleados empleadoToEntity(UsuarioRequestDTO dto) {
        if (dto == null)
            return null;

        return Empleados.builder()
                .legajo(dto.legajo())
                .sector(dto.sector())
                .build();
    }
    public static UsuarioResponseDTO toDTO(Usuario entity){
        if (entity==null){
            return null;
        }
        return new UsuarioResponseDTO(entity.getIdUsuario(),
                entity.getNombre(), entity.getApellido(),
                entity.getDni(), entity.getEmail());
    }
}