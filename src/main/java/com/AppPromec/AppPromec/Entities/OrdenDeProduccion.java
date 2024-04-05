package com.AppPromec.AppPromec.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ordenDeProduccion")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrdenDeProduccion {

    @Id
    @Column(name = "id_orden_de_produccion")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "numero_de_produccion")
    private String numero_de_produccion;

    @ManyToOne
    @JoinColumn(name = "id_produccion")
    private Produccion produccion;

}
