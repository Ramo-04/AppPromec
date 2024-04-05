package com.AppPromec.AppPromec.Service;



import com.AppPromec.AppPromec.Entities.Produccion;

import java.util.List;

public interface ProduccionService {

    public List<Produccion> findAll() throws Exception;

    public void create(Produccion produccion);


    public void delete(Produccion produccion);


    public void update(Produccion produccion);

    Produccion findById(Long id_produccion);



}