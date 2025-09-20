package com.fernandesjf.cadastro_usuario.controller;

import com.fernandesjf.cadastro_usuario.business.UsuarioService;
import com.fernandesjf.cadastro_usuario.infrastructure.DTOs.UsuarioRequestDTO;
import com.fernandesjf.cadastro_usuario.infrastructure.DTOs.UsuarioResponseDTO;
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
  public ResponseEntity<UsuarioResponseDTO> salvarUsuario(@RequestBody UsuarioRequestDTO usuario) {
    UsuarioResponseDTO salvo = usuarioService.salvarUsuario(usuario);
    return ResponseEntity.ok(salvo);
  }

  @GetMapping("/buscar")
  public ResponseEntity<UsuarioResponseDTO> buscarUsuarioPorEmail(@RequestParam String email) {
    return ResponseEntity.ok(usuarioService.buscarUsuarioPorEmail(email));
  }

  @DeleteMapping("/{email}")
  public ResponseEntity<Void> deletarUsuarioPorEmail(@PathVariable String email) {
    usuarioService.deletarUsuarioPorEmail(email);
    return ResponseEntity.noContent().build();
  }

  @PutMapping("/{id}")
  public ResponseEntity<UsuarioResponseDTO> atualizarUsuarioPorId(
      @PathVariable Integer id, @RequestBody UsuarioRequestDTO usuario) {
    UsuarioResponseDTO atualizado = usuarioService.atualizarUsuarioPorId(id, usuario);
    return ResponseEntity.ok(atualizado);
  }
}
