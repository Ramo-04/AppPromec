package com.AppPromec.AppPromec.Service.Imp;


import com.AppPromec.AppPromec.Entities.Usuario;
import com.AppPromec.AppPromec.Repository.UsuarioRepository;
import com.AppPromec.AppPromec.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioImp implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public List<Usuario> findAll() throws Exception {
        return this.usuarioRepository.findAll();
    }

    @Override
    public void create(Usuario usuario) {
        this.usuarioRepository.save(usuario);

    }

    @Override
    public void delete(Usuario usuario) {
        this.usuarioRepository.delete(usuario);

    }

    @Override
    public void update(Usuario usuario) {
        this.usuarioRepository.save(usuario);

    }

    @Override
    public Usuario findById(Long id_usuario) {
        return this.usuarioRepository.findById(id_usuario).orElse(null);
    }
}
