package com.fernandesjf.cadastro_usuario.infrastructure.repositories;

import com.fernandesjf.cadastro_usuario.infrastructure.entities.Usuario;
import jakarta.transaction.Transactional;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

  Optional<Usuario> findByEmail(String email);

  @Transactional
  void deleteByEmail(String email);
}
