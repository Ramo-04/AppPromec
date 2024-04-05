package com.AppPromec.AppPromec.Service;



import com.AppPromec.AppPromec.Entities.Empleado;

import java.util.List;

public interface EmpleadoService {

    public List<Empleado> findAll() throws Exception;
    public void create(Empleado empleado);

    public void delete(Empleado empleado);

    public void update(Empleado empleado);

    Empleado findById(Long id_empleado);

}
