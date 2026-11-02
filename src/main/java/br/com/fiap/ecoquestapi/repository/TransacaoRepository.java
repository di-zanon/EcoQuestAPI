package br.com.fiap.ecoquestapi.repository;

import br.com.fiap.ecoquestapi.model.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransacaoRepository extends JpaRepository<Transacao, Long> {
}