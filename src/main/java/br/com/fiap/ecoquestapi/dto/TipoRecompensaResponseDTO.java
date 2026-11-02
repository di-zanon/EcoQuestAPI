package br.com.fiap.ecoquestapi.dto;

import br.com.fiap.ecoquestapi.model.TipoRecompensa;

public record TipoRecompensaResponseDTO(Long id, String nomeTipo, String descricao) {
    public TipoRecompensaResponseDTO(TipoRecompensa tipo) {
        this(tipo.getId(), tipo.getNomeTipo(), tipo.getDescricao());
    }
}