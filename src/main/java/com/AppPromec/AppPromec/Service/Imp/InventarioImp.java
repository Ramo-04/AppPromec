package com.AppPromec.AppPromec.Service.Imp;


import com.AppPromec.AppPromec.Entities.Inventario;
import com.AppPromec.AppPromec.Repository.InventarioRepository;
import com.AppPromec.AppPromec.Service.InventarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventarioImp implements InventarioService {

    @Autowired
    private InventarioRepository inventarioRepository;

    @Override
    public List<Inventario> findAll() throws Exception {
        return this.inventarioRepository.findAll();
    }

    @Override
    public void create(Inventario inventario) {
        this.inventarioRepository.save(inventario);

    }

    @Override
    public void delete(Inventario inventario) {
        this.inventarioRepository.delete(inventario);

    }

    @Override
    public void update(Inventario inventario) {
        this.inventarioRepository.save(inventario);
    }
    @Override
    public Inventario findById(Long id_inventario) {
        return this.inventarioRepository.findById(id_inventario).orElse(null);
    }
}