package com.AppPromec.AppPromec.Controller;
import com.AppPromec.AppPromec.Entities.Usuario;
import com.AppPromec.AppPromec.Service.Imp.UsuarioImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/api/Usuario/", method = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.HEAD})
@CrossOrigin("http://localhost:3000")


public class UsuarioController {

    @Autowired
    private UsuarioImp usuarioImp;


    //CREATE USUARIO

    @PostMapping("create")
    public ResponseEntity<Map<String, Object>> create(@RequestBody Map<String, Object> request) {
        Map<String, Object> response = new HashMap<>();

        try {
            System.out.println("@@@@" + request);

            Usuario usuario = new Usuario();

            usuario.setContrasena(request.get("contraseña").toString());

            usuario.setDireccion(request.get("direccion").toString());

            usuario.setCorreo(request.get("correo").toString());

            usuario.setTelefono(request.get("telefono").toString());




            this.usuarioImp.create(usuario);

            response.put("status", "succes");
            response.put("data", "Registro exitoso");
        } catch (Exception e) {

            response.put("status", HttpStatus.BAD_GATEWAY);
            response.put("data", e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.BAD_GATEWAY);


        }
        return new ResponseEntity<>(response, HttpStatus.OK);


    }
    //FIND ALL USUARIO
    @GetMapping("all")

    public ResponseEntity<Map<String, Object>> findAll() {

        Map<String, Object> response = new HashMap<>();

        try {

            List<Usuario> usuarioList = this.usuarioImp.findAll();
            response.put("status", "succes");
            response.put("data", usuarioList);
        } catch (Exception e) {

            response.put("status", HttpStatus.BAD_GATEWAY);
            response.put("data", e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.BAD_GATEWAY);


        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    //FIND ID USUARIO

    @GetMapping("/list/{id_usuario}")

    public ResponseEntity<Map<String, Object>> findById(@PathVariable Long id_usuario) {
        Map<String, Object> response = new HashMap<>();

        try {
            Usuario usuario = this.usuarioImp.findById(id_usuario);
            response.put("status","success");
            response.put("data",usuario);
        } catch (Exception e) {
            response.put("status", HttpStatus.BAD_GATEWAY);
            response.put("data", e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.BAD_GATEWAY);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    //UPDATE USUARIO
    @PutMapping ("/update/{id_usuario}")

    public ResponseEntity<Map<String, Object>> findById(@PathVariable String id_usuario, @RequestBody Map<String, Object> request) {
        Map<String, Object> response = new HashMap<>();

        try {
            Usuario usuario = this.usuarioImp.findById(Long.parseLong(id_usuario));


            usuario.setContrasena(request.get("contraseña").toString());

            usuario.setDireccion(request.get("direccion").toString());

            usuario.setCorreo(request.get("correo").toString());

            usuario.setTelefono(request.get("telefono").toString());

            response.put("status", "succes");

            response.put("data", usuario);

            this.usuarioImp.update(usuario);

        } catch (Exception e) {

            response.put("status", HttpStatus.BAD_GATEWAY);
            response.put("data", e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.BAD_GATEWAY);

        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    //DELETE USUARIO
    @DeleteMapping("delete/{id_usuario}")

    public ResponseEntity<Map<String, Object>> delete(@PathVariable Long id_usuario) {
        Map<String, Object> response = new HashMap<>();

        try {

            Usuario usuario = this.usuarioImp.findById(id_usuario);

            usuarioImp.delete(usuario);

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
