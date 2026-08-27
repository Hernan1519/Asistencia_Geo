package com.app.geoasist.repositorio;

import com.app.geoasist.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UsuarioReposity extends JpaRepository<Usuario,Long> {
    Optional<Usuario> findByDni(Long dni);
    boolean existsByDni(Long dni);
    List<Usuario> findByApellido(String apellido);

    Optional<Usuario> findByEmail(String email);

    @Modifying
    @Query("DELETE FROM Usuario u WHERE u.dni = :dni")
    int deleteByDni(Long dni);
}
