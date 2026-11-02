package br.com.fiap.ecoquestapi.dto;

import br.com.fiap.ecoquestapi.model.Transacao;
import java.time.LocalDate;

public record TransacaoResponseDTO(
        Long idTransacao,
        Character tipo,
        Integer valor,
        LocalDate dataTransacao,
        String motivo,
        Long idUsuario,
        String nomeUsuario,
        Long idAcao,
        String nomeAcao
) {
    public TransacaoResponseDTO(Transacao transacao) {
        this(
                transacao.getId(),
                transacao.getTipo(),
                transacao.getValor(),
                transacao.getDataTransacao(),
                transacao.getMotivo(),
                transacao.getUsuario() != null ? transacao.getUsuario().getId() : null,
                transacao.getUsuario() != null ? transacao.getUsuario().getNome() : null,
                transacao.getAcao() != null ? transacao.getAcao().getIdAcao() : null,
                transacao.getAcao() != null ? transacao.getAcao().getNomeAcao() : null
        );
    }
}