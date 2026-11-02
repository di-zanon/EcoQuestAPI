package br.com.fiap.ecoquestapi.dto;

import br.com.fiap.ecoquestapi.model.AcaoSustentavel;

public record AcaoSustentavelResponseDTO(
        Long idAcao,
        String nomeAcao,
        String descricao,
        Double impacto,
        Double fatorBonus,
        Integer pontuacaoBase,
        String periodicidade,
        Long idTipoAcao,
        String nomeTipoAcao
) {
    public AcaoSustentavelResponseDTO(AcaoSustentavel acao) {
        this(
                acao.getIdAcao(),
                acao.getNomeAcao(),
                acao.getDescricao(),
                acao.getImpacto(),
                acao.getFatorBonus(),
                acao.getPontuacaoBase(),
                acao.getPeriodicidade(),
                acao.getTipoAcao() != null ? acao.getTipoAcao().getId() : null,
                acao.getTipoAcao() != null ? acao.getTipoAcao().getNomeTipo() : null
        );
    }
}