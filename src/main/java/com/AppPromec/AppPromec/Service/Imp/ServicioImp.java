package com.AppPromec.AppPromec.Service.Imp;


import com.AppPromec.AppPromec.Entities.Servicio;
import com.AppPromec.AppPromec.Repository.ServicioRepository;
import com.AppPromec.AppPromec.Service.ServicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class ServicioImp implements ServicioService {


    @Autowired
    private ServicioRepository servicioRepository;

    @Override
    public List<Servicio> findAll() throws Exception {
        return this.servicioRepository.findAll();
    }

    @Override
    public void create(Servicio servicio) {
        this.servicioRepository.save(servicio);

    }

    @Override
    public void delete(Servicio servicio) {
        this.servicioRepository.delete(servicio);

    }

    @Override
    public void update(Servicio servicio) {
        this.servicioRepository.save(servicio);


    }
    @Override
    public Servicio findById(Long id_servicio) {
        return this.servicioRepository.findById(id_servicio).orElse(null);
    }
}
