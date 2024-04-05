package com.AppPromec.AppPromec.Service;



import com.AppPromec.AppPromec.Entities.AsignacionTarea;

import java.util.List;

public interface AsignacionTareaService {

    public List<AsignacionTarea> findAll() throws Exception;


    public void create(AsignacionTarea asignacionTarea);


    public void delete(AsignacionTarea asignacionTarea);


    public void update(AsignacionTarea asignacionTarea);

    AsignacionTarea findById(Long id_asignacion_tarea);
}
