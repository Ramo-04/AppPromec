package com.AppPromec.AppPromec.Repository;


import com.AppPromec.AppPromec.Entities.OrdenDeProduccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdenDeProduccionRepository extends JpaRepository<OrdenDeProduccion, Long> {

}
