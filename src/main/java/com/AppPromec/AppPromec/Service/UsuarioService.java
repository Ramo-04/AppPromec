package com.AppPromec.AppPromec.Service;



import com.AppPromec.AppPromec.Entities.Usuario;

import java.util.List;

public interface UsuarioService {

    public List<Usuario> findAll() throws Exception;

    public void create(Usuario usuario);


    public void delete(Usuario usuario);



    public void update(Usuario usuario);

    Usuario findById(Long id_usuario);

}