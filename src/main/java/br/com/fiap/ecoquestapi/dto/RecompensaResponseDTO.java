package br.com.fiap.ecoquestapi.dto;

import br.com.fiap.ecoquestapi.model.Recompensa;

public record RecompensaResponseDTO(
        Long id,
        String descricao,
        Integer pontosNecessarios,
        Long idTipoRecompensa,
        String nomeTipoRecompensa
) {
    public RecompensaResponseDTO(Recompensa recompensa) {
        this(
                recompensa.getId(),
                recompensa.getDescricao(),
                recompensa.getPontosNecessarios(),
                recompensa.getTipoRecompensa() != null ? recompensa.getTipoRecompensa().getId() : null,
                recompensa.getTipoRecompensa() != null ? recompensa.getTipoRecompensa().getNomeTipo() : null
        );
    }
}