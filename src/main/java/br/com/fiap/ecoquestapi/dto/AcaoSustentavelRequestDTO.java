package br.com.fiap.ecoquestapi.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record AcaoSustentavelRequestDTO(
        @NotNull(message = "O ID do tipo de ação é obrigatório")
        Long idTipoAcao,

        @NotBlank(message = "O nome da ação é obrigatório")
        @Size(min = 3, max = 100, message = "O nome deve ter entre 3 e 100 caracteres")
        String nomeAcao,

        String descricao,

        @NotNull(message = "O impacto é obrigatório")
        @Min(value = 0, message = "O impacto mínimo é 0")
        @Max(value = 10, message = "O impacto máximo é 10")
        Double impacto,

        Double fatorBonus,

        @NotNull(message = "A pontuação base é obrigatória")
        Integer pontuacaoBase,

        String periodicidade
) {}