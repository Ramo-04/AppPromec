package com.AppPromec.AppPromec.Repository;


import com.AppPromec.AppPromec.Entities.Inventario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventarioRepository extends JpaRepository<Inventario, Long> {

}
