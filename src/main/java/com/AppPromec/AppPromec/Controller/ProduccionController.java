package com.AppPromec.AppPromec.Controller;


import com.AppPromec.AppPromec.Entities.Empleado;
import com.AppPromec.AppPromec.Entities.Inventario;
import com.AppPromec.AppPromec.Entities.Produccion;
import com.AppPromec.AppPromec.Service.Imp.EmpleadoImp;
import com.AppPromec.AppPromec.Service.Imp.InventarioImp;
import com.AppPromec.AppPromec.Service.Imp.ProduccionImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/api/Produccion", method = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.HEAD})
@CrossOrigin("*")
public class ProduccionController {

    @Autowired
    private ProduccionImp produccionImp;

    @Autowired
    private InventarioImp inventarioImp;

    @Autowired
    private EmpleadoImp empleadoImp;
    @PostMapping("create")
    public ResponseEntity<Map<String, Object>> create (@RequestBody Map<String, Object> request) {
        Map<String, Object> response = new HashMap<>();

        try {
            System.out.println("@@@@"+ request);

            Produccion produccion = new Produccion();


            produccion.setDescripcion_producto(request.get("descripcion_producto").toString());

            produccion.setTrabajadores_disponibles(Integer.parseInt( request.get("trabajadores_disponibles").toString()));

            produccion.setElementos_stock(Integer.parseInt( request.get("elementos_stock").toString()));


            Inventario inventario = inventarioImp.findById(Long.parseLong(request.get("id_inventario").toString()));
            produccion.setInventario(inventario);

            Empleado empleado = empleadoImp.findById(Long.parseLong(request.get("id_empleado").toString()));
            produccion.setEmpleado(empleado);



            this.produccionImp.create(produccion);

            response.put("status", "succes");

            response.put("data", "Registro exitoso");

        }catch (Exception e){
            response.put("status", HttpStatus.BAD_GATEWAY);

            response.put("data",e.getMessage());

            return new ResponseEntity<>(response, HttpStatus.BAD_GATEWAY);


        }
        return new ResponseEntity<>(response, HttpStatus.OK);


    }
    //FIND ALL PRODUCCION
    @GetMapping("all")
    public ResponseEntity<Map<String, Object>> findAll(){
        Map<String, Object> response = new HashMap<>();

        try {
            List<Produccion> produccionList=this.produccionImp.findAll();
            response.put("status", "succes");

            response.put("data", produccionList);
        }catch (Exception e){
            response.put("status",HttpStatus.BAD_GATEWAY);

            response.put("data",e.getMessage());

            return new ResponseEntity<>(response, HttpStatus.BAD_GATEWAY);


        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    //UPDATE PRODUCCION
    @GetMapping("/update/{id_produccion}")
    public ResponseEntity<Map<String, Object>> findById(@PathVariable Long id_produccion, @RequestBody Map<String, Object> request) {
        Map<String, Object> response = new HashMap<>();

        try {
            Produccion produccion = this.produccionImp.findById(id_produccion);

            produccion.setDescripcion_producto((String) request.get("descripcion_producto"));
            produccion.setTrabajadores_disponibles((Integer) request.get("trabajadores_disponibles"));
            produccion.setElementos_stock((Integer) request.get("elementos_stock"));

            response.put("status", "succes");

            response.put("data", produccion);

            this.produccionImp.update(produccion);
        } catch (Exception e) {

            response.put("status", HttpStatus.BAD_GATEWAY);
            response.put("data", e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.BAD_GATEWAY);

        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    //DELETE INVENTARIO
    @DeleteMapping("delete/{id_produccion}")
    public ResponseEntity<Map<String, Object>> delete(@PathVariable Long id_produccion) {
        Map<String, Object> response = new HashMap<>();

        try {

            Produccion produccion = this.produccionImp.findById(id_produccion);

            produccionImp.delete(produccion);

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
