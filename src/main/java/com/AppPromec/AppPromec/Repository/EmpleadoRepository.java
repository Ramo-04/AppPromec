package com.AppPromec.AppPromec.Repository;


import com.AppPromec.AppPromec.Entities.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {


}
