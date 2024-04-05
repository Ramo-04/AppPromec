package com.AppPromec.AppPromec.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "INVENTARIO")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Inventario {
    @Id
    @Column(name = "id_inventario")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "cantidad_inventario_stock")
    private int cantidad_inventario_stock;

    @Column(name = "entrada_inventario")
    private int entrada_inventario;

    @Column(name = "salida_inventario")
    private int salida_inventario;

    @Column(name = "precio_entrada")
    private double precio_entrada;

    @Column(name = "precio_salida")
    private double precio_salida;

    @Column(name = "producto")
    private String producto;

    @OneToMany(mappedBy = "inventario")
    private List<Produccion> produccion;

}
