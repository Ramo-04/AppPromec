package com.AppPromec.AppPromec.Repository;


import com.AppPromec.AppPromec.Entities.Servicio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicioRepository extends JpaRepository<Servicio, Long> {


}

