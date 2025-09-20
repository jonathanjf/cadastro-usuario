package com.fernandesjf.cadastro_usuario.infrastructure.DTOs;

public record UsuarioResponseDTO(
    Integer id,
    String nome,
    String email
) {}