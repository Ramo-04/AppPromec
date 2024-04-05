package com.AppPromec.AppPromec.Service.Imp;


import com.AppPromec.AppPromec.Entities.Produccion;
import com.AppPromec.AppPromec.Repository.ProduccionRepository;
import com.AppPromec.AppPromec.Service.ProduccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class ProduccionImp implements ProduccionService {


    @Autowired
    private ProduccionRepository produccionRepository;


    @Override
    public List<Produccion> findAll() throws Exception {
        return this.produccionRepository.findAll();
    }

    @Override
    public void create(Produccion produccion) {
        this.produccionRepository.save(produccion);

    }

    @Override
    public void delete(Produccion produccion) {
       this.produccionRepository.delete(produccion);
    }

    @Override
    public void update(Produccion produccion) {
        this.produccionRepository.save(produccion);

    }

    @Override
    public Produccion findById(Long id_produccion) {
        return this.produccionRepository.findById(id_produccion).orElse(null);
    }
}
