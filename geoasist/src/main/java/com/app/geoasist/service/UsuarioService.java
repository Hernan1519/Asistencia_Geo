package com.app.geoasist.service;

import com.app.geoasist.dto.UsuarioRequestDTO;
import com.app.geoasist.dto.UsuarioResponseDTO;
import com.app.geoasist.mapper.UsuarioMapper;
import com.app.geoasist.model.Empleados;
import com.app.geoasist.model.Roles;
import com.app.geoasist.model.Usuario;
import com.app.geoasist.repositorio.EmpleadosRepository;
import com.app.geoasist.repositorio.RolesRepository;
import com.app.geoasist.repositorio.UsuarioReposity;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioReposity usuarioRepository;
    private final RolesRepository rolReposity;
    private final EmpleadosRepository empleadoRepository;
    private final PasswordEncoder passewordEncoder;
    @Transactional(readOnly=true)
    public List<UsuarioResponseDTO> obtenerUsuarios() {

        return usuarioRepository.findAll().stream()
                .map(UsuarioMapper::toDTO).toList();
    }
    @Transactional(readOnly=true)
    public Optional<UsuarioResponseDTO> buscarPorDni(Long dni){
        return usuarioRepository.findByDni(dni)
                .map(UsuarioMapper::toDTO);
    }

    @Transactional
    public UsuarioResponseDTO crearUsuario(UsuarioRequestDTO requestDTO) {
        if(usuarioRepository.existsByDni(requestDTO.dni())){
            throw new IllegalArgumentException("El dni ya existe");
        }
        Roles rol = rolReposity.findById(requestDTO.idRol())
                .orElseThrow(() -> new RuntimeException("El rol " + requestDTO.idRol() + " no existe"));

        Usuario nuevoUsuario=UsuarioMapper.toEntity(requestDTO);
        nuevoUsuario.setPassword(passewordEncoder.encode(requestDTO.password()));

        nuevoUsuario.setRol(rol);
        Usuario usuarioGuardado=usuarioRepository.save(nuevoUsuario);

        Empleados nuevoEmpleado= UsuarioMapper.empleadoToEntity(requestDTO);
        nuevoEmpleado.setUsuario(usuarioGuardado);

        nuevoEmpleado.setAlta(LocalDate.now());

        if(requestDTO.idSupervisor() != null ){
            Empleados supervisor= empleadoRepository.findById(requestDTO.idSupervisor())
                    .orElseThrow(() -> new RuntimeException("Error el supervisor no existe"));
            nuevoEmpleado.setSupervisor(supervisor);
        }
        empleadoRepository.save(nuevoEmpleado);
        return UsuarioMapper.toDTO(usuarioGuardado);
    }
    @Transactional(readOnly=true)
    public List<UsuarioResponseDTO> buscarApellido(String apellido){
        return usuarioRepository.findByApellido(apellido).stream()
                .map(UsuarioMapper::toDTO)
                .toList();
    }

    @Transactional
    public boolean eliminarUsuario(Long dni) {
        return usuarioRepository.deleteByDni(dni) > 0;
    }

    @Transactional
    public Optional<UsuarioResponseDTO> updateUsuario(Long dni, UsuarioRequestDTO usuarioUpd) {
        return usuarioRepository.findByDni(dni)
                .map(existente -> {

                    if (!existente.getDni().equals(usuarioUpd.dni()) && usuarioRepository.existsByDni(usuarioUpd.dni())) {
                        throw new IllegalArgumentException("El nuevo DNI " + usuarioUpd.dni() + " ya está en uso por otro usuario.");
                    }

                    existente.setNombre(usuarioUpd.nombre());
                    existente.setApellido(usuarioUpd.apellido());
                    existente.setDni(usuarioUpd.dni());
                    existente.setEmail(usuarioUpd.email());


                    Usuario usuarioActualizado = usuarioRepository.save(existente);
                    return UsuarioMapper.toDTO(usuarioActualizado);
                });
    }
}