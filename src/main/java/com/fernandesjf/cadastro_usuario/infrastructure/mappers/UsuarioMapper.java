package com.fernandesjf.cadastro_usuario.infrastructure.mappers;

import com.fernandesjf.cadastro_usuario.infrastructure.DTOs.UsuarioRequestDTO;
import com.fernandesjf.cadastro_usuario.infrastructure.DTOs.UsuarioResponseDTO;
import com.fernandesjf.cadastro_usuario.infrastructure.entities.Usuario;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(
    componentModel = "spring",
    nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface UsuarioMapper {

  // Converte entidade para DTO de resposta
  UsuarioResponseDTO toResponseDTO(Usuario usuario);

  // Converte DTO de request para entidade
  Usuario toEntity(UsuarioRequestDTO dto);

  // Atualiza a entidade existente com dados do DTO de request (apenas campos não nulos)
  void updateFromRequestDTO(UsuarioRequestDTO dto, @MappingTarget Usuario entity);
}
