package com.AppPromec.AppPromec.Controller;


import com.AppPromec.AppPromec.Entities.Empleado;
import com.AppPromec.AppPromec.Entities.Servicio;
import com.AppPromec.AppPromec.Service.Imp.EmpleadoImp;
import com.AppPromec.AppPromec.Service.Imp.ServicioImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/api/Servicio", method = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.HEAD})
@CrossOrigin("http://localhost:3000")public class ServicioController {

    @Autowired
    private ServicioImp servicioImp;
    @Autowired
    private EmpleadoImp empleadoImp;

    @PostMapping("create")
    public ResponseEntity<Map<String, Object>> create (@RequestBody Map<String, Object> request) {
        Map<String, Object> response = new HashMap<>();

        try {
            System.out.println("@@@@"+ request);

            Servicio servicio = new Servicio();

            servicio.setNombre_servicio(request.get("nombre_servicio").toString());

            servicio.setDescripcion_servicio(( request.get("descripcion_servicio").toString()));

            servicio.setCalidad_servicio(( request.get("calidad_servicio").toString()));

            servicio.setTipo_servicio(( request.get("tipo_servicio").toString()));

            Empleado empleado = empleadoImp.findById(Long.parseLong(request.get("id_empleado").toString()));
            servicio.setEmpleado(empleado);



            this.servicioImp.create(servicio);

            response.put("status", "succes");

            response.put("data", "Registro exitoso");

        }catch (Exception e){
            response.put("status", HttpStatus.BAD_GATEWAY);

            response.put("data",e.getMessage());

            return new ResponseEntity<>(response, HttpStatus.BAD_GATEWAY);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);


    }
    @GetMapping("all")
    public ResponseEntity<Map<String, Object>> findAll(){
        Map<String, Object> response = new HashMap<>();

        try {
            List<Servicio> servicioList=this.servicioImp.findAll();

            response.put("status", "succes");

            response.put("data", servicioList);
        }catch (Exception e){
            response.put("status",HttpStatus.BAD_GATEWAY);

            response.put("data",e.getMessage());

            return new ResponseEntity<>(response, HttpStatus.BAD_GATEWAY);


        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    //UPDATE SERVICIO
    @PutMapping("/update/{id_servicio}")
    public ResponseEntity<Map<String, Object>> findById(@PathVariable Long id_servicio, @RequestBody Map<String, Object> request) {
        Map<String, Object> response = new HashMap<>();

        try {
            Servicio servicio = this.servicioImp.findById(id_servicio);

            servicio.setTipo_servicio((String) request.get("tipo_servicio"));

            servicio.setDescripcion_servicio((String) request.get("descripcion_servicio"));

            servicio.setCalidad_servicio((String) request.get("calidad_servicio"));

            servicio.setTipo_servicio((String) request.get("tipo_servicio"));

            response.put("status", "succes");

            response.put("data", servicio);

            this.servicioImp.update(servicio);
        } catch (Exception e) {

            response.put("status", HttpStatus.BAD_GATEWAY);
            response.put("data", e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.BAD_GATEWAY);

        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    //DELETE SERVICIO
    @DeleteMapping("delete/{id_servicio}")
    public ResponseEntity<Map<String, Object>> delete(@PathVariable Long id_servicio) {
        Map<String, Object> response = new HashMap<>();

        try {

            Servicio servicio = this.servicioImp.findById(id_servicio);

            servicioImp.delete(servicio);

            response.put("status", "success");

            response.put("data", "Registro borrado correctamente");
        } catch (Exception e) {
            response.put("status", HttpStatus.BAD_GATEWAY);

            response.put("data", e.getMessage());

            return new ResponseEntity<>(response, HttpStatus.BAD_GATEWAY);
        }


        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
