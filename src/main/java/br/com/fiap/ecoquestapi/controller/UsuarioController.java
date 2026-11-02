package br.com.fiap.ecoquestapi.controller;

import br.com.fiap.ecoquestapi.dto.UsuarioRequestDTO;
import br.com.fiap.ecoquestapi.dto.UsuarioResponseDTO;
import br.com.fiap.ecoquestapi.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public List<UsuarioResponseDTO> listar() {
        return usuarioService.listarTodos().stream()
                .map(UsuarioResponseDTO::new) // Converte cada Usuario para DTO
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public UsuarioResponseDTO buscarPorId(@PathVariable Long id) {
        return new UsuarioResponseDTO(usuarioService.buscarPorId(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UsuarioResponseDTO criar(@Valid @RequestBody UsuarioRequestDTO dto) {
        // O Service vai converter o DTO em Entidade
        return new UsuarioResponseDTO(usuarioService.criar(dto));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long id) {
        usuarioService.excluir(id);
    }
}