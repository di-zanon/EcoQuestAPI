package br.com.fiap.ecoquestapi.repository;

import br.com.fiap.ecoquestapi.model.TipoAcao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoAcaoRepository extends JpaRepository<TipoAcao, Long> {
}