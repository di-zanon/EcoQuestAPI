package br.com.fiap.ecoquestapi.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record RecompensaRequestDTO(
        @NotNull(message = "O ID do tipo de recompensa é obrigatório")
        Long idTipoRecompensa,

        @NotBlank(message = "A descrição é obrigatória")
        String descricao,

        @NotNull(message = "Os pontos necessários são obrigatórios")
        @Positive(message = "Os pontos devem ser maiores que zero")
        Integer pontosNecessarios
) {}