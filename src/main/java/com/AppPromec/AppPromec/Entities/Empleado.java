package com.AppPromec.AppPromec.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "EMPLEADOS")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Empleado {

    @Id
    @Column(name = "id_empleado")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "sueldo_bruto")
    private Double sueldo;

    @Column(name = "cargo")
    private String cargo;

    @Column(name = "nombre_completo_empleado")
    private String nombreCompleto;

    @OneToMany(mappedBy = "empleado", cascade = CascadeType.ALL)
    private List<AsignacionTarea> asignacionTarea;

    @OneToMany(mappedBy = "empleado")
    private List<Produccion> produccion;

    @OneToMany(mappedBy = "empleado")
    private List<Servicio> servicio;


    @ManyToOne(optional = true)
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;
}