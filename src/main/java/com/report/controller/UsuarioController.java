package com.report.controller;

import com.report.model.Reporte;
import com.report.model.Usuario;
import com.report.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;
    
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @PostMapping("/register")
    public ResponseEntity<Usuario> register(@RequestBody Usuario usuario) {
        usuario.setPassword(bCryptPasswordEncoder.encode(usuario.getPassword()));
        return ResponseEntity.ok(usuarioService.save(usuario));
    }

    @PostMapping("/registerList")
    public ResponseEntity<List<Usuario>> registerList(@RequestBody List<Usuario> usuarios) {
        usuarios.forEach(usuario -> usuario.setPassword(bCryptPasswordEncoder.encode(usuario.getPassword())));
        List<Usuario> savedUsuarios = usuarioService.saveAll(usuarios);
        return ResponseEntity.ok(savedUsuarios);
    }

	@GetMapping
    public ResponseEntity<List<Usuario>> getAllUsuarios() {
        return ResponseEntity.ok(usuarioService.findAll());
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Usuario> updateUsuario(@PathVariable Long id, @RequestBody Usuario usuario) {
	usuario.setId(id);
	return ResponseEntity.ok(usuarioService.save(usuario));	
	
	}	

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteUsuario(@PathVariable Long id) {
		usuarioService.deleteById(id);
		return ResponseEntity.noContent().build();

}
}