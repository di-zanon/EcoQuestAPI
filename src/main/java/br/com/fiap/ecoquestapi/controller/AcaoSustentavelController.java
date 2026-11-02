package br.com.fiap.ecoquestapi.controller;

import br.com.fiap.ecoquestapi.dto.AcaoSustentavelRequestDTO;
import br.com.fiap.ecoquestapi.dto.AcaoSustentavelResponseDTO;
import br.com.fiap.ecoquestapi.service.AcaoSustentavelService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/acoes")
public class AcaoSustentavelController {

    @Autowired
    private AcaoSustentavelService service;

    @GetMapping
    public List<AcaoSustentavelResponseDTO> listar() {
        return service.listarTodas().stream()
                .map(AcaoSustentavelResponseDTO::new)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public AcaoSustentavelResponseDTO buscarPorId(@PathVariable Long id) {
        return new AcaoSustentavelResponseDTO(service.buscarPorId(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AcaoSustentavelResponseDTO criar(@Valid @RequestBody AcaoSustentavelRequestDTO dto) {
        return new AcaoSustentavelResponseDTO(service.criar(dto));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long id) {
        service.excluir(id);
    }
}