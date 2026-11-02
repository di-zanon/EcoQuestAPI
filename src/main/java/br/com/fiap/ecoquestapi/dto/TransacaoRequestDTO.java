package br.com.fiap.ecoquestapi.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record TransacaoRequestDTO(
        @NotNull(message = "O ID do usuário é obrigatório")
        Long idUsuario,

        Long idAcao, // Opcional, pois pode ser um débito (resgate) sem ação

        @NotNull(message = "O tipo é obrigatório")
        Character tipo,

        @NotNull(message = "O valor é obrigatório")
        @Positive(message = "O valor deve ser maior que zero")
        Integer valor,

        String motivo
) {}