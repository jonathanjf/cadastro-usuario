package com.fernandesjf.cadastro_usuario.infrastructure.DTOs;

public record UsuarioRequestDTO(
    String nome,
    String email
) {}