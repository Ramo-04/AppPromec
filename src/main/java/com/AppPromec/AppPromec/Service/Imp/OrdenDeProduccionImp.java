package com.AppPromec.AppPromec.Service.Imp;


import com.AppPromec.AppPromec.Entities.OrdenDeProduccion;
import com.AppPromec.AppPromec.Repository.OrdenDeProduccionRepository;
import com.AppPromec.AppPromec.Service.OrdenDeProduccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdenDeProduccionImp implements OrdenDeProduccionService {


    @Autowired
    private OrdenDeProduccionRepository ordenDeProduccionRepository;

    @Override
    public List<OrdenDeProduccion> findAll() throws Exception {
        return null;
    }

    @Override
    public void create(OrdenDeProduccion ordenDeProduccion) {

    }

    @Override
    public void delete(OrdenDeProduccion ordenDeProduccion) {

    }

    @Override
    public void update(OrdenDeProduccion ordenDeProduccion) {
    }

    @Override
    public OrdenDeProduccion findById(Long id_orden_de_produccion) {
        return this.ordenDeProduccionRepository.findById(id_orden_de_produccion).orElse(null);
    }
}
