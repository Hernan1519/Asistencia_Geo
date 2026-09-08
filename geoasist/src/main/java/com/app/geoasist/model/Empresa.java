package com.app.geoasist.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "empresa")
@Getter
@Setter
@NoArgsConstructor
public class Empresa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_empresa")
    private Integer idEmpresa;

    @Column(name = "nombre",nullable = false)
    private String nombre;

    @Column(name = "descripcion",nullable = false)
    private String descripcion;

    @Column(name = "direccion_central")
    private String direccionCentral;

    @Column(name = "email",nullable = false,unique = true)
    private String email;

    @OneToMany(mappedBy ="empresa",fetch = FetchType.LAZY)
    private List<Sucursal> sucursales;

}

