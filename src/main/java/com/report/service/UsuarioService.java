package com.report.service;

import com.report.model.Reporte;
import com.report.model.Usuario;
import com.report.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario save(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public List<Usuario> saveAll(List<Usuario> usuarios) {
        return usuarioRepository.saveAll(usuarios);
    }

    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    public Usuario findByUsername(String username) {
        return usuarioRepository.findByUsername(username);
    }

    public Usuario findById(Long id) {
    return usuarioRepository.findById(id).orElse(null);
    }

    public void deleteById(Long id) {
	usuarioRepository.deleteById(id);
    }
}