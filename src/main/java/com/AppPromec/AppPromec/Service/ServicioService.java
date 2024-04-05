package com.AppPromec.AppPromec.Service;

import com.AppPromec.AppPromec.Entities.Servicio;

import java.util.List;

public interface ServicioService {

    public List<Servicio> findAll() throws Exception;

    public void create(Servicio servicio);

    public void delete(Servicio servicio);

    public void update(Servicio servicio);


    Servicio findById(Long id_servicio);

}
