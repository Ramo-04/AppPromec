package com.AppPromec.AppPromec.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "PRODUCCION")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Produccion {

    @Id
    @Column(name = "id_produccion")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "descripcion_producto")
    private String descripcion_producto;

    @Column(name = "trabajadores_disponibles")
    private Integer trabajadores_disponibles;

    @Column(name = "elementos_stock")
    private Integer elementos_stock;

    @ManyToOne
    @JoinColumn(name = "id_inventario")
    private Inventario inventario;

    @ManyToOne
    @JoinColumn(name = "id_empleado")
    private Empleado empleado;

    @OneToMany(mappedBy = "produccion")
    private List<OrdenDeProduccion> ordenDeProduccion;

}
