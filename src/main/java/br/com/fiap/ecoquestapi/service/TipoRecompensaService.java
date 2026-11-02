package br.com.fiap.ecoquestapi.service;

import br.com.fiap.ecoquestapi.dto.TipoRecompensaRequestDTO;
import br.com.fiap.ecoquestapi.model.TipoRecompensa;
import br.com.fiap.ecoquestapi.repository.TipoRecompensaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import java.util.List;

@Service
@Transactional
public class TipoRecompensaService {

    @Autowired
    private TipoRecompensaRepository repository;

    public List<TipoRecompensa> listarTodos() {
        return repository.findAll();
    }

    public TipoRecompensa buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Tipo de recompensa não encontrado"));
    }

    public TipoRecompensa criar(TipoRecompensaRequestDTO dto) {
        TipoRecompensa tipo = new TipoRecompensa();
        tipo.setNomeTipo(dto.nomeTipo());
        tipo.setDescricao(dto.descricao());
        return repository.save(tipo);
    }

    public void excluir(Long id) {
        TipoRecompensa tipo = buscarPorId(id);
        repository.delete(tipo);
    }
}