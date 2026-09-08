package com.app.geoasist.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "asignacion_personal")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AsignacionPersonal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_asignacion")
    private Long idAsignacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_empleado", nullable = false)
    private Empleados empleado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_sucursal", nullable = false)
    private Sucursal sucursal;

    @Column(name = "fecha_inicio", nullable = false)
    private LocalDate fechaInicio;

    @Column(name = "fecha_finalizacion")
    private LocalDate fechaFinalizacion;

    @Column(name = "estado_asignacion")
    private EstadoAsignacion estadoAsignacion;

    @OneToMany(
            mappedBy = "asignacion",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Horario> horarios;

    @Column(name = "activo", nullable = false)
    private Boolean activo;
}