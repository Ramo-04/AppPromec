package com.AppPromec.AppPromec.Repository;


import com.AppPromec.AppPromec.Entities.AsignacionTarea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AsignacionTareaRepository extends JpaRepository<AsignacionTarea, Long> {


}
