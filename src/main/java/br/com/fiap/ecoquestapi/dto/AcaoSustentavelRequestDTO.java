package br.com.fiap.ecoquestapi.dto;

import jakarta.validation.constraints.*;

public record AcaoSustentavelRequestDTO(
        @NotNull(message = "O ID do tipo de ação é obrigatório")
        Long idTipoAcao,

        @NotBlank(message = "O nome da ação é obrigatório")
        @Size(min = 3, max = 100, message = "O nome deve ter entre 3 e 100 caracteres")
        String nomeAcao,

        String descricao,

        @NotNull(message = "O impacto é obrigatório")
        @DecimalMin(value = "0.0", message = "O impacto mínimo é 0")
        @DecimalMax(value = "10.0", message = "O impacto máximo é 10")
        Double impacto,

        @DecimalMin(value = "0.0", message = "O fator bônus mínimo é 0")
        @DecimalMax(value = "0.5", message = "O fator bônus máximo é 0.5")
        Double fatorBonus,

        @NotNull(message = "A pontuação base é obrigatória")
        Integer pontuacaoBase,

        String periodicidade
) {}