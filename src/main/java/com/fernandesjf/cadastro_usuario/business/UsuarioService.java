package com.fernandesjf.cadastro_usuario.business;

import com.fernandesjf.cadastro_usuario.infrastructure.DTOs.UsuarioRequestDTO;
import com.fernandesjf.cadastro_usuario.infrastructure.DTOs.UsuarioResponseDTO;
import com.fernandesjf.cadastro_usuario.infrastructure.entities.Usuario;
import com.fernandesjf.cadastro_usuario.infrastructure.mappers.UsuarioMapper;
import com.fernandesjf.cadastro_usuario.infrastructure.repositories.UsuarioRepository;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

  private final UsuarioRepository repository;
  private final UsuarioMapper mapper;

  public UsuarioService(UsuarioRepository repository, UsuarioMapper mapper) {
    this.repository = repository;
    this.mapper = mapper;
  }

  public UsuarioResponseDTO salvarUsuario(UsuarioRequestDTO dto) {
    Usuario usuario = mapper.toEntity(dto);
    Usuario salvo = repository.saveAndFlush(usuario);
    return mapper.toResponseDTO(salvo);
  }

  public UsuarioResponseDTO buscarUsuarioPorEmail(String email) {
    Usuario usuario = repository.findByEmail(email)
        .orElseThrow(() -> new RuntimeException("Email não encontrado"));
    return mapper.toResponseDTO(usuario);
  }

  public void deletarUsuarioPorEmail(String email) {
    repository.deleteByEmail(email);
  }

  public UsuarioResponseDTO atualizarUsuarioPorId(Integer id, UsuarioRequestDTO dto) {
    Usuario usuarioEntity = repository.findById(id)
        .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

    mapper.updateFromRequestDTO(dto, usuarioEntity); // atualiza apenas campos não nulos
    Usuario salvo = repository.saveAndFlush(usuarioEntity);
    return mapper.toResponseDTO(salvo);
  }
}

