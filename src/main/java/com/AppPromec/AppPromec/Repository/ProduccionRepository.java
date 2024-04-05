package com.AppPromec.AppPromec.Repository;


import com.AppPromec.AppPromec.Entities.Produccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProduccionRepository extends JpaRepository<Produccion, Long> {


}
