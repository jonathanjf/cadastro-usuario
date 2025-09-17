package com.fernandesjf.cadastro_usuario.controller;

import com.fernandesjf.cadastro_usuario.business.UsuarioService;
import com.fernandesjf.cadastro_usuario.infrastructure.entities.Usuario;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

  private final UsuarioService usuarioService;

  public UsuarioController(UsuarioService usuarioService) {
    this.usuarioService = usuarioService;
  }

  @PostMapping
  public ResponseEntity<Void> salvarUsuario(@RequestBody Usuario usuario) {
    usuarioService.savarUsuario(usuario);
    return ResponseEntity.ok().build();
  }

  @GetMapping
  public ResponseEntity<Usuario> buscarUsuarioPorEmail(@RequestParam String email) {
    return ResponseEntity.ok(usuarioService.buscarUsuarioPorEmail(email));
  }

  @DeleteMapping
  public ResponseEntity<Void> deletarUsuarioPorEmail(@RequestParam String email) {
    usuarioService.deletarUsuarioPorEmail(email);
    return ResponseEntity.ok().build();
  }

  @PutMapping
  public ResponseEntity<Usuario> atualizarUsuarioPorId(@RequestBody Usuario usuario) {
    usuarioService.atualizarUsuarioPorId(usuario.getId(), usuario);
    return ResponseEntity.ok().build();
  }
}