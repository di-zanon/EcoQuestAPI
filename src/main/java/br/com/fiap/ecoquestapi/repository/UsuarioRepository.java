package br.com.fiap.ecoquestapi.repository;

import br.com.fiap.ecoquestapi.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}