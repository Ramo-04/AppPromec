package com.AppPromec.AppPromec.Service.Imp;


import com.AppPromec.AppPromec.Entities.Empleado;
import com.AppPromec.AppPromec.Repository.EmpleadoRepository;
import com.AppPromec.AppPromec.Service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpleadoImp implements EmpleadoService {

    @Autowired
    private EmpleadoRepository empleadoRepository;

    @Override
    public List<Empleado> findAll() throws Exception {
        return this.empleadoRepository.findAll();
    }

    @Override
    public void create(Empleado empleado) {
        this.empleadoRepository.save(empleado);

    }

    @Override
    public void delete(Empleado empleado) {
        this.empleadoRepository.delete(empleado);

    }

    @Override
    public void update(Empleado empleado) {
        this.empleadoRepository.save(empleado);
    }

    @Override
    public Empleado findById(Long id_empleado) {
        return this.empleadoRepository.findById(id_empleado).orElse(null);
    }
}