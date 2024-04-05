package com.AppPromec.AppPromec.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "SERVICIOS")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Servicio {

    @Id
    @Column(name = "id_servicio")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre_servicio")
    private String nombreServicio;

    @Column(name = "descripcion_servicio")
    private String descripcionServicio;

    @Column(name = "calidad_servicio")
    private String calidadServicio;

    @Column(name = "tipo_servicio")
    private String tipo_servicio;

    @ManyToOne
    @JoinColumn(name = "id_empleado")
    private Empleado empleado;
}
