package com.AppPromec.AppPromec.Controller;


import com.AppPromec.AppPromec.Entities.Inventario;
import com.AppPromec.AppPromec.Entities.Usuario;
import com.AppPromec.AppPromec.Service.Imp.InventarioImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/api/Inventario", method = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.HEAD})
@CrossOrigin("http://localhost:3000")
public class InventarioController {

    @Autowired
    private InventarioImp inventarioImp;


    //CREATE INVENTARIO

    @PostMapping("create")
    public ResponseEntity<Map<String, Object>> create(@RequestBody Map<String, Object> request) {
        Map<String, Object> response = new HashMap<>();

        try {
            System.out.println("@@@@" + request);

            Inventario inventario = new Inventario();


            inventario.setEntrada_inventario(Integer.parseInt(request.get("entrada_inventario").toString()));

            inventario.setSalida_inventario(Integer.parseInt(request.get("salida_inventario").toString()));

            inventario.setPrecio_entrada(Double.parseDouble(request.get("precio_entrada").toString()));

            inventario.setPrecio_salida((Double.parseDouble(request.get("precio_salida").toString())));

            inventario.setProducto(request.get("producto").toString());

            inventario.setCantidad_inventario_stock(Integer.parseInt(request.get("cantidad_inventario_stock").toString()));



            this.inventarioImp.create(inventario);

            response.put("status", "succes");
            response.put("data", "Registro exitoso");
        } catch (Exception e) {

            response.put("status", HttpStatus.BAD_GATEWAY);
            response.put("data", e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.BAD_GATEWAY);


        }
        return new ResponseEntity<>(response, HttpStatus.OK);


    }

    // FIND ALL INVENTARIO
    @GetMapping("all")
    public ResponseEntity<List<Inventario>> findAll() {
        try {

            List<Inventario> inventarioList = this.inventarioImp.findAll();

            return new ResponseEntity<>(inventarioList, HttpStatus.OK);

        } catch (Exception e) {

            return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
        }
    }


    //UPDATE INVENTARIO
    @PutMapping("/update/{id_inventario}")
    public ResponseEntity<Map<String, Object>> findById(@PathVariable Long id_inventario, @RequestBody Map<String, Object> request) {
        Map<String, Object> response = new HashMap<>();

        try {
            Inventario inventario = this.inventarioImp.findById(id_inventario);

            inventario.setPrecio_entrada(Integer.parseInt (request.get("precio_entrada").toString()));
            inventario.setPrecio_salida(Integer.parseInt (request.get("precio_salida").toString()));
            inventario.setSalida_inventario(Integer.parseInt (request.get("salida_inventario").toString()));
            inventario.setEntrada_inventario(Integer.parseInt(request.get("entrada_inventario").toString()));
            inventario.setProducto(request.get("producto").toString());

            response.put("status", "succes");

            response.put("data", inventario);

            this.inventarioImp.update(inventario);
        } catch (Exception e) {

            response.put("status", HttpStatus.BAD_GATEWAY);
            response.put("data", e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.BAD_GATEWAY);

        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    //FIND ID USUARIO

    @GetMapping("/list/{id_inventario}")

    public ResponseEntity<Map<String, Object>> findById(@PathVariable Long id_inventario) {
        Map<String, Object> response = new HashMap<>();

        try {
            Inventario inventario = this.inventarioImp.findById(id_inventario);

            response.put("status","success");

            response.put("data",inventario);

        } catch (Exception e) {

            response.put("status", HttpStatus.BAD_GATEWAY);

            response.put("data", e.getMessage());

            return new ResponseEntity<>(response, HttpStatus.BAD_GATEWAY);

        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }



    //DELETE INVENTARIO
    @DeleteMapping("delete/{id_invetario}")
    public ResponseEntity<Map<String, Object>> delete(@PathVariable Long id_invetario) {
        Map<String, Object> response = new HashMap<>();

        try {

            Inventario inventario = this.inventarioImp.findById(id_invetario);

            inventarioImp.delete(inventario);

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


