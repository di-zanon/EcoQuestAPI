package br.com.fiap.ecoquestapi.service;

import br.com.fiap.ecoquestapi.dto.TransacaoRequestDTO;
import br.com.fiap.ecoquestapi.model.AcaoSustentavel;
import br.com.fiap.ecoquestapi.model.Transacao;
import br.com.fiap.ecoquestapi.model.Usuario;
import br.com.fiap.ecoquestapi.repository.AcaoSustentavelRepository;
import br.com.fiap.ecoquestapi.repository.TransacaoRepository;
import br.com.fiap.ecoquestapi.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import java.util.List;

@Service
@Transactional
public class TransacaoService {

    @Autowired
    private TransacaoRepository repository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private AcaoSustentavelRepository acaoRepository;

    public List<Transacao> listarTodas() {
        return repository.findAll();
    }

    public Transacao buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Transação não encontrada"));
    }

    // Recebe DTO e converte para Entidade
    public Transacao criar(TransacaoRequestDTO dto) {
        // 1. Busca o Usuário no banco
        Usuario usuario = usuarioRepository.findById(dto.idUsuario())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado"));

        // 2. Busca a Ação no banco (se foi enviada)
        AcaoSustentavel acao = null;
        if (dto.idAcao() != null) {
            acao = acaoRepository.findById(dto.idAcao())
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Ação não encontrada"));
        }

        // 3. Monta a Entidade
        Transacao transacao = new Transacao();
        transacao.setUsuario(usuario);
        transacao.setAcao(acao);
        transacao.setTipo(dto.tipo());
        transacao.setValor(dto.valor());
        transacao.setMotivo(dto.motivo());

        return repository.save(transacao);
    }

    public void excluir(Long id) {
        Transacao transacao = buscarPorId(id);
        repository.delete(transacao);
    }

    public Transacao atualizar(Long id, TransacaoRequestDTO dto) {
        Transacao transacao = buscarPorId(id);

        // Regra de negócio: não permitir trocar o usuário de uma transação existente
        // (preserva a integridade histórica e o cálculo do Ranking)
        if (!transacao.getUsuario().getId().equals(dto.idUsuario())) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "Não é permitido alterar o usuário de uma transação existente");
        }

        // Regra de negócio: não permitir trocar a ação vinculada
        Long idAcaoAtual = transacao.getAcao() != null ? transacao.getAcao().getIdAcao() : null;
        if (!java.util.Objects.equals(idAcaoAtual, dto.idAcao())) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "Não é permitido alterar a ação sustentável de uma transação existente");
        }

        // Apenas campos mutáveis são atualizados
        transacao.setTipo(dto.tipo());
        transacao.setValor(dto.valor());
        transacao.setMotivo(dto.motivo());

        return repository.save(transacao);
    }
}