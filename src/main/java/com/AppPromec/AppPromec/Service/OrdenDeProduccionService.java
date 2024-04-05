package com.AppPromec.AppPromec.Service;



import com.AppPromec.AppPromec.Entities.OrdenDeProduccion;

import java.util.List;

public interface OrdenDeProduccionService {

    public List<OrdenDeProduccion> findAll() throws Exception;


    public void create(OrdenDeProduccion ordenDeProduccion);


    public void delete(OrdenDeProduccion ordenDeProduccion);


    public void update(OrdenDeProduccion ordenDeProduccion);

    OrdenDeProduccion findById(Long id_orden_de_produccion);

}
