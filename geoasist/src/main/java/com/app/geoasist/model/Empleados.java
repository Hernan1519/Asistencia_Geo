package com.app.geoasist.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "empleados")
public class Empleados {

    @Id
    @Column(name = "usuario_id")
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @Column(name = "legajo", unique = true, nullable = false)
    private Integer legajo;

    @Column(name = "sector", nullable = false, length = 50)
    private String sector;

    @Column(name = "fecha_alta", nullable = false)
    private LocalDate alta;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_supervisor")
    private Empleados supervisor;
}