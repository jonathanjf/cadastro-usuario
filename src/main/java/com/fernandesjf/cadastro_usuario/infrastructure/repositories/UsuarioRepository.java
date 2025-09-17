package com.fernandesjf.cadastro_usuario.infrastructure.repositories;

import com.fernandesjf.cadastro_usuario.infrastructure.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
}
