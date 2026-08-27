package com.app.geoasist.repositorio;

import com.app.geoasist.model.Empleados;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpleadosRepository extends JpaRepository<Empleados,Long> {
}
