package com.AppPromec.AppPromec.Service.Imp;

import com.AppPromec.AppPromec.Entities.AsignacionTarea;
import com.AppPromec.AppPromec.Repository.AsignacionTareaRepository;
import com.AppPromec.AppPromec.Service.AsignacionTareaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AsignacionTareaImp implements AsignacionTareaService {

    @Autowired
    private AsignacionTareaRepository asignacionTareaRepository;

    @Override
    public List<AsignacionTarea> findAll() throws Exception {
        return this.asignacionTareaRepository.findAll();
    }

    @Override
    public void create(AsignacionTarea asignacionTarea) {
        this.asignacionTareaRepository.save(asignacionTarea);

    }

    @Override
    public void delete(AsignacionTarea asignacionTarea) {
        this.asignacionTareaRepository.delete(asignacionTarea);

    }

    @Override
    public void update(AsignacionTarea asignacionTarea) {
        this.asignacionTareaRepository.save(asignacionTarea);

    }

    @Override
    public AsignacionTarea findById(Long id_asignacion_tarea) {
        return this.asignacionTareaRepository.findById(id_asignacion_tarea).orElse(null);
    }
}
