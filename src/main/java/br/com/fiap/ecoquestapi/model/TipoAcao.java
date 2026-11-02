package br.com.fiap.ecoquestapi.model;

import jakarta.persistence.*;

@Entity
@Table(name = "TB_TIPO_ACAO")
public class TipoAcao {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_tipo_acao")
    @SequenceGenerator(name = "seq_tipo_acao", sequenceName = "SEQ_TIPO_ACAO", allocationSize = 1)
    @Column(name = "ID_TIPO_ACAO")
    private Long id;

    @Column(nullable = false)
    private String nomeTipo;

    private String descricao;

    // Construtor vazio
    public TipoAcao() {}

    public TipoAcao(String nomeTipo, String descricao) {
        this.nomeTipo = nomeTipo;
        this.descricao = descricao;
    }

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNomeTipo() { return nomeTipo; }
    public void setNomeTipo(String nomeTipo) { this.nomeTipo = nomeTipo; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
}