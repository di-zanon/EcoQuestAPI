package br.com.fiap.ecoquestapi.repository;

import br.com.fiap.ecoquestapi.dto.RankingResponseDTO;
import br.com.fiap.ecoquestapi.model.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TransacaoRepository extends JpaRepository<Transacao, Long> {

    @Query("SELECT new br.com.fiap.ecoquestapi.dto.RankingResponseDTO(" +
            "t.usuario.id, t.usuario.nome, SUM(t.valor)) " +
            "FROM Transacao t " +
            "WHERE t.tipo = 'C' " +
            "GROUP BY t.usuario.id, t.usuario.nome " +
            "ORDER BY SUM(t.valor) DESC")
    List<RankingResponseDTO> obterRanking();
}