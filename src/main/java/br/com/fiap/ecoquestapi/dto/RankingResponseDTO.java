package br.com.fiap.ecoquestapi.dto;

public record RankingResponseDTO(
        Long idUsuario,
        String nomeUsuario,
        Long totalPontos
) {}