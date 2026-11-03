package br.com.fiap.ecoquestapi.controller;

import br.com.fiap.ecoquestapi.dto.TipoRecompensaRequestDTO;
import br.com.fiap.ecoquestapi.dto.TipoRecompensaResponseDTO;
import br.com.fiap.ecoquestapi.service.TipoRecompensaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/tipos-recompensa")
public class TipoRecompensaController {

    @Autowired
    private TipoRecompensaService service;

    @GetMapping
    public List<TipoRecompensaResponseDTO> listar() {
        return service.listarTodos().stream()
                .map(TipoRecompensaResponseDTO::new)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public TipoRecompensaResponseDTO buscarPorId(@PathVariable Long id) {
        return new TipoRecompensaResponseDTO(service.buscarPorId(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TipoRecompensaResponseDTO criar(@Valid @RequestBody TipoRecompensaRequestDTO dto) {
        return new TipoRecompensaResponseDTO(service.criar(dto));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long id) {
        service.excluir(id);
    }

    @PutMapping("/{id}")
    public TipoRecompensaResponseDTO atualizar(@PathVariable Long id,
                                               @Valid @RequestBody TipoRecompensaRequestDTO dto) {
        return new TipoRecompensaResponseDTO(service.atualizar(id, dto));
    }
}