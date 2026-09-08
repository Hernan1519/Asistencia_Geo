package com.app.geoasist.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "asistencia")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Asistencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_asistencia")
    private Long idAsistencia;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_asignacion", nullable = false)
    private AsignacionPersonal asignacion;

    @Column(name = "fecha_logica", nullable = false)
    private LocalDate fecha;

    @Column(name = "entrada_esperada", nullable = false)
    private LocalDateTime horaEstimada;

    @Column(name = "salida_esperada", nullable = false)
    private LocalDateTime salidaEstimada;

    @Column(name = "entrada_fichada")
    private LocalDateTime entradaFichada;

    @Column(name = "salida_fichada")
    private LocalDateTime salidaFichada;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado", nullable = false)
    private EstadoAsistencia estado;
}