package com.fernandesjf.cadastro_usuario.business;

import com.fernandesjf.cadastro_usuario.infrastructure.entities.Usuario;
import com.fernandesjf.cadastro_usuario.infrastructure.repositories.UsuarioRepository;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
  private final UsuarioRepository repository;

  public UsuarioService(UsuarioRepository repository) {
    this.repository = repository;
  }

  public void savarUsuario(Usuario usuario) {
    repository.saveAndFlush(usuario);
  }

  public Usuario buscarUsuarioPorEmail(String email) {
    return repository.findByEmail(email).orElseThrow(
        () -> new RuntimeException("Email não encontrado")
    );
  }

  public void deletarUsuarioPorEmail(String email) {
    repository.deleteByEmail(email);
  }

  public void atualizarUsuarioPorEmail(String email, Usuario usuario) {
    Usuario usuarioEntity = buscarUsuarioPorEmail(email);

    Usuario usuarioAtualizado = Usuario.builder()
        .email(usuario.getEmail() != null ? usuario.getEmail() : usuarioEntity.getEmail())
        .nome(usuario.getNome() != null ? usuario.getNome() : usuarioEntity.getNome())
        .id(usuarioEntity.getId())
        .build();

    repository.saveAndFlush(usuarioAtualizado);

  }
}
