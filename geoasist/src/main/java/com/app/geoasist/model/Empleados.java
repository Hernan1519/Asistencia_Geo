package com.app.geoasist.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "empleados")
public class Empleados {

    @Id
    @Column(name = "id_empleado")
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "id_empleado", nullable = false)
    private Usuario usuario;

    @Column(name = "legajo", unique = true, nullable = false)
    private Integer legajo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_sector", nullable = false)
    private Sector sector;

    @Column(name = "fecha_alta", nullable = false)
    private LocalDate alta;

    @OneToMany(mappedBy = "empleado", fetch = FetchType.LAZY)
    private List<AsignacionPersonal> asignaciones;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_supervisor")
    private Empleados supervisor;
}