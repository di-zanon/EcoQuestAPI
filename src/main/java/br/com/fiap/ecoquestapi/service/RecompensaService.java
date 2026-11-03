package br.com.fiap.ecoquestapi.service;

import br.com.fiap.ecoquestapi.dto.RecompensaRequestDTO;
import br.com.fiap.ecoquestapi.model.Recompensa;
import br.com.fiap.ecoquestapi.model.TipoRecompensa;
import br.com.fiap.ecoquestapi.repository.RecompensaRepository;
import br.com.fiap.ecoquestapi.repository.TipoRecompensaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import java.util.List;

@Service
@Transactional
public class RecompensaService {

    @Autowired
    private RecompensaRepository repository;

    @Autowired
    private TipoRecompensaRepository tipoRecompensaRepository;

    public List<Recompensa> listarTodas() {
        return repository.findAll();
    }

    public Recompensa buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Recompensa não encontrada"));
    }

    public Recompensa criar(RecompensaRequestDTO dto) {
        TipoRecompensa tipo = tipoRecompensaRepository.findById(dto.idTipoRecompensa())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Tipo de recompensa não encontrado"));

        Recompensa recompensa = new Recompensa();
        recompensa.setTipoRecompensa(tipo);
        recompensa.setDescricao(dto.descricao());
        recompensa.setPontosNecessarios(dto.pontosNecessarios());

        return repository.save(recompensa);
    }

    public void excluir(Long id) {
        Recompensa recompensa = buscarPorId(id);
        repository.delete(recompensa);
    }

    public Recompensa atualizar(Long id, RecompensaRequestDTO dto) {
        Recompensa recompensa = buscarPorId(id);

        TipoRecompensa tipo = tipoRecompensaRepository.findById(dto.idTipoRecompensa())
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Tipo de recompensa não encontrado"));

        recompensa.setTipoRecompensa(tipo);
        recompensa.setDescricao(dto.descricao());
        recompensa.setPontosNecessarios(dto.pontosNecessarios());

        return repository.save(recompensa);
    }
}