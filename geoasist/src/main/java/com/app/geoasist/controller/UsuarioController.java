package com.app.geoasist.controller;

import com.app.geoasist.dto.UsuarioRequestDTO;
import com.app.geoasist.dto.UsuarioResponseDTO;
import com.app.geoasist.service.UsuarioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    private final UsuarioService service;

    @PostMapping
    public ResponseEntity<UsuarioResponseDTO> crearUsuario(@Valid @RequestBody UsuarioRequestDTO requestDTO) {
        UsuarioResponseDTO usuarioCreado = service.crearUsuario(requestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioCreado);
    }

    @GetMapping("/listado")
    public ResponseEntity<List<UsuarioResponseDTO>> listaUsuario() {
        List<UsuarioResponseDTO> listado = service.obtenerUsuarios();
        return ResponseEntity.ok(listado);
    }

    @GetMapping("/dni/{dni}")
    public ResponseEntity<UsuarioResponseDTO> buscarDni(@PathVariable Long dni) {
        return service.buscarPorDni(dni)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<UsuarioResponseDTO>> buscarApellido(@RequestParam String apellido) {
        List<UsuarioResponseDTO> listaApellidos = service.buscarApellido(apellido);
        return ResponseEntity.ok(listaApellidos);
    }

    @DeleteMapping("/dni/{dni}")
    public ResponseEntity<Void> eliminarUsuario(@PathVariable Long dni) {
        if (service.eliminarUsuario(dni)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/dni/{dni}")
    public ResponseEntity<UsuarioResponseDTO> modificarUsuario(
            @PathVariable Long dni,
            @Valid @RequestBody UsuarioRequestDTO usuarioM) {

        return service.updateUsuario(dni, usuarioM)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}