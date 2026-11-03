package br.com.fiap.ecoquestapi.controller;

import br.com.fiap.ecoquestapi.dto.RecompensaRequestDTO;
import br.com.fiap.ecoquestapi.dto.RecompensaResponseDTO;
import br.com.fiap.ecoquestapi.service.RecompensaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/recompensas")
public class RecompensaController {

    @Autowired
    private RecompensaService service;

    @GetMapping
    public List<RecompensaResponseDTO> listar() {
        return service.listarTodas().stream()
                .map(RecompensaResponseDTO::new)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public RecompensaResponseDTO buscarPorId(@PathVariable Long id) {
        return new RecompensaResponseDTO(service.buscarPorId(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public RecompensaResponseDTO criar(@Valid @RequestBody RecompensaRequestDTO dto) {
        return new RecompensaResponseDTO(service.criar(dto));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long id) {
        service.excluir(id);
    }

    @PutMapping("/{id}")
    public RecompensaResponseDTO atualizar(@PathVariable Long id,
                                           @Valid @RequestBody RecompensaRequestDTO dto) {
        return new RecompensaResponseDTO(service.atualizar(id, dto));
    }
}