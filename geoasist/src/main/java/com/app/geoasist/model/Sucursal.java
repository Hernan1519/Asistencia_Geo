package com.app.geoasist.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "sucursal")
@NoArgsConstructor
@Setter
@Getter

public class Sucursal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_sucursal")
    private Integer idSucursal;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_empresa", nullable = false)
    private Empresa empresa;

    @Column(name = "domicilio", nullable = false)
    private String domicilio;

    @Column(name = "latitud", nullable = false)
    private Double latitud;

    @Column(name = "longitud", nullable = false)
    private Double longitud;

    @Column(name = "limite", nullable = false)
    private Double limite;

    @Column(name = "activo", nullable = false)
    private Boolean activo;

    @OneToMany(mappedBy = "sucursal",fetch = FetchType.LAZY)
    private List<AsignacionPersonal> asignaciones;

    @OneToMany(mappedBy ="sucursal",fetch = FetchType.LAZY)
    private List<CodigoQr> codigoQr;
}