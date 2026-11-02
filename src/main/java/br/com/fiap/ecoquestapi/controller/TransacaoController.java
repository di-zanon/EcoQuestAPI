package br.com.fiap.ecoquestapi.controller;

import br.com.fiap.ecoquestapi.dto.TransacaoRequestDTO;
import br.com.fiap.ecoquestapi.dto.TransacaoResponseDTO;
import br.com.fiap.ecoquestapi.service.TransacaoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/transacoes")
public class TransacaoController {

    @Autowired
    private TransacaoService service;

    @GetMapping
    public List<TransacaoResponseDTO> listar() {
        return service.listarTodas().stream()
                .map(TransacaoResponseDTO::new)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public TransacaoResponseDTO buscarPorId(@PathVariable Long id) {
        return new TransacaoResponseDTO(service.buscarPorId(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TransacaoResponseDTO criar(@Valid @RequestBody TransacaoRequestDTO dto) {
        return new TransacaoResponseDTO(service.criar(dto));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long id) {
        service.excluir(id);
    }
}