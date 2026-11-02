package br.com.fiap.ecoquestapi.dto;

import br.com.fiap.ecoquestapi.model.TipoAcao;

public record TipoAcaoResponseDTO(Long id, String nomeTipo, String descricao) {
    public TipoAcaoResponseDTO(TipoAcao tipoAcao) {
        this(tipoAcao.getId(), tipoAcao.getNomeTipo(), tipoAcao.getDescricao());
    }
}