package com.app.geoasist.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "sector")
@NoArgsConstructor
@Getter
@Setter
public class Sector {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_sector")
    private Integer idSector;

    @Column(name = "tipo_sector", nullable = false, unique = true)
    private String tipoSector;

    @Column(name = "activo", nullable = false)
    private Boolean activo;
}