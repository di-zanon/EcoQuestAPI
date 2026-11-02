package br.com.fiap.ecoquestapi.controller;

import br.com.fiap.ecoquestapi.dto.RankingResponseDTO;
import br.com.fiap.ecoquestapi.repository.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/ranking")
public class RankingController {

    @Autowired
    private TransacaoRepository transacaoRepository;

    @GetMapping
    public List<RankingResponseDTO> obterRanking() {
        return transacaoRepository.obterRanking();
    }
}