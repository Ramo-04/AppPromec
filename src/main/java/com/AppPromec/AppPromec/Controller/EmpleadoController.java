package com.AppPromec.AppPromec.Controller;


import com.AppPromec.AppPromec.Entities.Empleado;
import com.AppPromec.AppPromec.Entities.Usuario;
import com.AppPromec.AppPromec.Service.Imp.EmpleadoImp;
import com.AppPromec.AppPromec.Service.Imp.UsuarioImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/api/Empleado/", method = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.HEAD})
@CrossOrigin("http://localhost:3000")

public class EmpleadoController {

    @Autowired
    private EmpleadoImp empleadoImp;

    @Autowired
    private UsuarioImp usuarioImp;


    //CREATE EMPELADO

    @PostMapping("create")
    public ResponseEntity<Map<String, Object>> create(@RequestBody Map<String, Object> request) {
        Map<String, Object> response = new HashMap<>();

        try {
            System.out.println("@@@@" + request);

            Empleado empleado = new Empleado();

            empleado.setSueldo_bruto(Double.parseDouble(request.get("sueldo_bruto").toString()));

            empleado.setCargo((request.get("cargo").toString()));

            empleado.setNombre_completo_empleado((request.get("nombre_completo_empleado").toString()));

            Usuario usuario = usuarioImp.findById(Long.parseLong(request.get("id_usuario").toString()));
            empleado.setUsuario(usuario);

            this.empleadoImp.create(empleado);

            response.put("status", "succes");
            response.put("data", "Registro exitoso");
        } catch (Exception e) {

            response.put("status", HttpStatus.BAD_GATEWAY);
            response.put("data", e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.BAD_GATEWAY);


        }
        return new ResponseEntity<>(response, HttpStatus.OK);


    }
    //FIND ALL EMPLEADO
    @GetMapping("all")
    public ResponseEntity<Map<String, Object>> findAll() {

        Map<String, Object> response = new HashMap<>();

        try {

            List<Empleado> empleadoList = this.empleadoImp.findAll();
            response.put("status", "succes");
            response.put("data", empleadoList);
        } catch (Exception e) {

            response.put("status", HttpStatus.BAD_GATEWAY);
            response.put("data", e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.BAD_GATEWAY);


        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    //FIND ID EMPLEADO

    @GetMapping("/list/{id_empleado}")
    public ResponseEntity<Map<String, Object>> findById(@PathVariable Long id_empleado) {
        Map<String, Object> response = new HashMap<>();

        try {
            Empleado empleado = this.empleadoImp.findById(id_empleado);
            response.put("status","success");
            response.put("data",empleado);
        } catch (Exception e) {
            response.put("status", HttpStatus.BAD_GATEWAY);
            response.put("data", e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.BAD_GATEWAY);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    //UPDATE EMPLEADO
    @PutMapping("/update/{id_empleado}")
    public ResponseEntity<Map<String, Object>> findById(@PathVariable Long id_empleado, @RequestBody Map<String, Object> request) {
        Map<String, Object> response = new HashMap<>();

        try {
            Empleado empleado = this.empleadoImp.findById(id_empleado);

            empleado.setNombre_completo_empleado(request.get("nombre_completo_empleado").toString());
            empleado.setCargo(request.get("cargo").toString());
            empleado.setSueldo_bruto(Double.parseDouble(request.get("sueldo_bruto").toString()));

            response.put("status", "succes");

            response.put("data", empleado);

            this.empleadoImp.update(empleado);

        } catch (Exception e) {

            response.put("status", HttpStatus.BAD_GATEWAY);
            response.put("data", e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.BAD_GATEWAY);

        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    //DELETE EMPLEADO
    @DeleteMapping("delete/{id_empleado}")
    public ResponseEntity<Map<String, Object>> delete(@PathVariable Long id_empleado) {
        Map<String, Object> response = new HashMap<>();

        try {

            Empleado empleado = this.empleadoImp.findById(id_empleado);

            empleadoImp.delete(empleado);

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
