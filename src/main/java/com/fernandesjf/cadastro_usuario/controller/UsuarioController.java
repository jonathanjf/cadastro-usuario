package com.fernandesjf.cadastro_usuario.controller;

import com.fernandesjf.cadastro_usuario.business.UsuarioService;
import com.fernandesjf.cadastro_usuario.infrastructure.DTOs.UsuarioDTO;
import com.fernandesjf.cadastro_usuario.infrastructure.entities.Usuario;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
  public ResponseEntity<Void> salvarUsuario(@RequestBody UsuarioDTO usuario) {
    usuarioService.salvarUsuario(usuario);
    return ResponseEntity.ok().build();
  }

  @GetMapping("/buscar")
  public ResponseEntity<UsuarioDTO> buscarUsuarioPorEmail(@RequestParam String email) {
    return ResponseEntity.ok(usuarioService.buscarUsuarioPorEmail(email));
  }

  @DeleteMapping("/{email}")
  public ResponseEntity<Void> deletarUsuarioPorEmail(@PathVariable String email) {
    usuarioService.deletarUsuarioPorEmail(email);
    return ResponseEntity.noContent().build();
  }

  @PutMapping("/{id}")
  public ResponseEntity<UsuarioDTO> atualizarUsuarioPorId(
      @PathVariable Integer id, @RequestBody UsuarioDTO usuario) {
        UsuarioDTO atualizado = usuarioService.atualizarUsuarioPorId(id, usuario);
        return ResponseEntity.ok(atualizado);
  }

}