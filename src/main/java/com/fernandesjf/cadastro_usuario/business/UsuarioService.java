package com.fernandesjf.cadastro_usuario.business;

import com.fernandesjf.cadastro_usuario.infrastructure.DTOs.UsuarioRequestDTO;
import com.fernandesjf.cadastro_usuario.infrastructure.DTOs.UsuarioResponseDTO;
import com.fernandesjf.cadastro_usuario.infrastructure.entities.Usuario;
import com.fernandesjf.cadastro_usuario.infrastructure.repositories.UsuarioRepository;

public class UsuarioService {
  private final UsuarioRepository repository;

  public UsuarioService(UsuarioRepository repository) {
    this.repository = repository;
  }

  public UsuarioResponseDTO salvarUsuario(UsuarioRequestDTO dto) {
    Usuario usuario = Usuario.builder()
        .nome(dto.nome())
        .email(dto.email())
        .build();

    Usuario salvo = repository.saveAndFlush(usuario);
    return toResponseDTO(salvo);
  }

  public UsuarioResponseDTO buscarUsuarioPorEmail(String email) {
    Usuario usuario = repository.findByEmail(email)
        .orElseThrow(() -> new RuntimeException("Email não encontrado"));
    return toResponseDTO(usuario);
  }

  public void deletarUsuarioPorEmail(String email) {
    repository.deleteByEmail(email);
  }

  public UsuarioResponseDTO atualizarUsuarioPorId(Integer id, UsuarioRequestDTO dto) {
    Usuario usuarioEntity = repository.findById(id)
        .orElseThrow(() -> new RuntimeException("Usuario não encontrado"));

    Usuario usuarioAtualizado = Usuario.builder()
        .id(usuarioEntity.getId()) // mantém ID do banco
        .nome(dto.nome() != null ? dto.nome() : usuarioEntity.getNome())
        .email(dto.email() != null ? dto.email() : usuarioEntity.getEmail())
        .build();

    Usuario salvo = repository.saveAndFlush(usuarioAtualizado);
    return toResponseDTO(salvo);
  }

  private UsuarioResponseDTO toResponseDTO(Usuario usuario) {
    return new UsuarioResponseDTO(usuario.getId(), usuario.getNome(), usuario.getEmail());
  }
}
