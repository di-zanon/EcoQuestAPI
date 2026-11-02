package br.com.fiap.ecoquestapi.dto;

import br.com.fiap.ecoquestapi.model.Usuario;

public record UsuarioResponseDTO(Long id, String nome, String email, String telefone) {
    // Metodo para converter a entidade de volta para DTO
    public UsuarioResponseDTO(Usuario usuario) {
        this(usuario.getId(), usuario.getNome(), usuario.getEmail(), usuario.getTelefone());
    }
}