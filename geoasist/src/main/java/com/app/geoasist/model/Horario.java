package com.app.geoasist.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.Set;

@Entity
@Table(name = "horario")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Horario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_horario")
    private Long idHorario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_asignacion", nullable = false)
    private AsignacionPersonal asignacion;

    @Column(name = "hora_entrada", nullable = false)
    private LocalTime horaEntrada;

    @Column(name = "hora_salida", nullable = false)
    private LocalTime horaSalida;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_turno", nullable = false)
    private TipoTurno tipoTurno;

    @ElementCollection
    @CollectionTable(
            name = "horario_dias",
            joinColumns = @JoinColumn(name = "id_horario")
    )
    @Enumerated(EnumType.STRING)
    @Column(name = "dia_semana", nullable = false)
    private Set<DayOfWeek> diasLaborables;
}