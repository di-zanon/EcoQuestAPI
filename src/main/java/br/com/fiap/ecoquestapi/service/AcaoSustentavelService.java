package br.com.fiap.ecoquestapi.service;

import br.com.fiap.ecoquestapi.dto.AcaoSustentavelRequestDTO;
import br.com.fiap.ecoquestapi.model.AcaoSustentavel;
import br.com.fiap.ecoquestapi.model.TipoAcao;
import br.com.fiap.ecoquestapi.repository.AcaoSustentavelRepository;
import br.com.fiap.ecoquestapi.repository.TipoAcaoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import java.util.List;

@Service
@Transactional
public class AcaoSustentavelService {

    @Autowired
    private AcaoSustentavelRepository repository;

    @Autowired
    private TipoAcaoRepository tipoAcaoRepository;

    public List<AcaoSustentavel> listarTodas() {
        return repository.findAll();
    }

    public AcaoSustentavel buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Ação não encontrada"));
    }

    // Recebe DTO e converte para Entidade
    public AcaoSustentavel criar(AcaoSustentavelRequestDTO dto) {
        // Busca o TipoAcao no banco
        TipoAcao tipoAcao = tipoAcaoRepository.findById(dto.idTipoAcao())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Tipo de ação não encontrado"));

        AcaoSustentavel acao = new AcaoSustentavel();
        acao.setNomeAcao(dto.nomeAcao());
        acao.setDescricao(dto.descricao());
        acao.setImpacto(dto.impacto());
        acao.setFatorBonus(dto.fatorBonus());
        acao.setPontuacaoBase(dto.pontuacaoBase());
        acao.setPeriodicidade(dto.periodicidade());
        acao.setTipoAcao(tipoAcao);

        return repository.save(acao);
    }

    public void excluir(Long id) {
        AcaoSustentavel acao = buscarPorId(id);
        repository.delete(acao);
    }
}