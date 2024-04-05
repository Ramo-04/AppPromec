package com.AppPromec.AppPromec.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "asignacionDeTareas")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AsignacionTarea {

    @Id
    @Column(name = "id_asignacion_de_tareas")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_empleado")
    private Empleado empleado;

}