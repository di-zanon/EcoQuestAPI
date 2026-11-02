package br.com.fiap.ecoquestapi.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

@Entity
@Table(name = "TB_ACAO_SUSTENTAVEL")
public class AcaoSustentavel {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_acao")
    @SequenceGenerator(name = "seq_acao", sequenceName = "SEQ_ACAO", allocationSize = 1)
    @Column(name = "ID_ACAO")
    @JsonAlias("id")
    private Long idAcao;

    @ManyToOne
    @JoinColumn(name = "id_tipo_acao", nullable = false)
    private TipoAcao tipoAcao;

    @Column(nullable = false)
    private String nomeAcao;

    private String descricao;

    @Min(0) @Max(10)
    private Double impacto;

    private Double fatorBonus;

    @Column(nullable = false)
    private Integer pontuacaoBase;

    private String periodicidade;

    // Construtor vazio
    public AcaoSustentavel() {}

    // Getters e Setters
    public Long getIdAcao() { return idAcao; }
    public void setIdAcao(Long idAcao) { this.idAcao = idAcao; }

    public TipoAcao getTipoAcao() { return tipoAcao; }
    public void setTipoAcao(TipoAcao tipoAcao) { this.tipoAcao = tipoAcao; }

    public String getNomeAcao() { return nomeAcao; }
    public void setNomeAcao(String nomeAcao) { this.nomeAcao = nomeAcao; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public Double getImpacto() { return impacto; }
    public void setImpacto(Double impacto) { this.impacto = impacto; }

    public Double getFatorBonus() { return fatorBonus; }
    public void setFatorBonus(Double fatorBonus) { this.fatorBonus = fatorBonus; }

    public Integer getPontuacaoBase() { return pontuacaoBase; }
    public void setPontuacaoBase(Integer pontuacaoBase) { this.pontuacaoBase = pontuacaoBase; }

    public String getPeriodicidade() { return periodicidade; }
    public void setPeriodicidade(String periodicidade) { this.periodicidade = periodicidade; }
}