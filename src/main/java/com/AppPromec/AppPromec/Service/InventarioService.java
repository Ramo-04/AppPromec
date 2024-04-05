package com.AppPromec.AppPromec.Service;



import com.AppPromec.AppPromec.Entities.Inventario;

import java.util.List;

public interface InventarioService {

    public List<Inventario> findAll() throws Exception;
    public void create(Inventario inventario);

    public void delete(Inventario inventario);

    public void update(Inventario inventario);

    Inventario findById(Long id_inventario);

}
