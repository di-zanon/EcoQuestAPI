package br.com.fiap.ecoquestapi.controller;

import br.com.fiap.ecoquestapi.dto.TipoAcaoRequestDTO;
import br.com.fiap.ecoquestapi.dto.TipoAcaoResponseDTO;
import br.com.fiap.ecoquestapi.service.TipoAcaoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/tipos")
public class TipoAcaoController {

    @Autowired
    private TipoAcaoService service;

    @GetMapping
    public List<TipoAcaoResponseDTO> listar() {
        return service.listarTodos().stream()
                .map(TipoAcaoResponseDTO::new)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public TipoAcaoResponseDTO buscarPorId(@PathVariable Long id) {
        return new TipoAcaoResponseDTO(service.buscarPorId(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TipoAcaoResponseDTO criar(@Valid @RequestBody TipoAcaoRequestDTO dto) {
        return new TipoAcaoResponseDTO(service.criar(dto));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long id) {
        service.excluir(id);
    }
}