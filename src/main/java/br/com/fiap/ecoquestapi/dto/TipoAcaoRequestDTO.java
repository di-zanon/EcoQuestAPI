package br.com.fiap.ecoquestapi.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record TipoAcaoRequestDTO(
        @NotBlank(message = "O nome do tipo é obrigatório")
        @Size(min = 3, max = 30, message = "O nome deve ter entre 3 e 30 caracteres")
        String nomeTipo,

        String descricao
) {}