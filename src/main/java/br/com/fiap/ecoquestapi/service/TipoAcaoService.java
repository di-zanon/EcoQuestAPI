package br.com.fiap.ecoquestapi.service;

import br.com.fiap.ecoquestapi.dto.TipoAcaoRequestDTO;
import br.com.fiap.ecoquestapi.model.TipoAcao;
import br.com.fiap.ecoquestapi.repository.TipoAcaoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import java.util.List;

@Service
@Transactional
public class TipoAcaoService {

    @Autowired
    private TipoAcaoRepository repository;

    public List<TipoAcao> listarTodos() {
        return repository.findAll();
    }

    public TipoAcao buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Tipo de ação não encontrado"));
    }

    // Recebe DTO e converte para Entidade
    public TipoAcao criar(TipoAcaoRequestDTO dto) {
        TipoAcao tipoAcao = new TipoAcao();
        tipoAcao.setNomeTipo(dto.nomeTipo());
        tipoAcao.setDescricao(dto.descricao());
        return repository.save(tipoAcao);
    }

    public void excluir(Long id) {
        TipoAcao tipoAcao = buscarPorId(id);
        repository.delete(tipoAcao);
    }

    public TipoAcao atualizar(Long id, TipoAcaoRequestDTO dto) {
        TipoAcao tipoAcao = buscarPorId(id);
        tipoAcao.setNomeTipo(dto.nomeTipo());
        tipoAcao.setDescricao(dto.descricao());
        return repository.save(tipoAcao);
    }
}