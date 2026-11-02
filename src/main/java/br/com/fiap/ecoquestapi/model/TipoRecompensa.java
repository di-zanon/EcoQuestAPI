package br.com.fiap.ecoquestapi.model;

import jakarta.persistence.*;

@Entity
@Table(name = "TB_TIPO_RECOMPENSA")
public class TipoRecompensa {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_tipo_recompensa")
    @SequenceGenerator(name = "seq_tipo_recompensa", sequenceName = "SEQ_TIPO_RECOMPENSA", allocationSize = 1)
    @Column(name = "ID_TIPO_RECOMPENSA")
    private Long id;

    @Column(name = "NOME_TIPO", nullable = false)
    private String nomeTipo;

    private String descricao;

    public TipoRecompensa() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNomeTipo() { return nomeTipo; }
    public void setNomeTipo(String nomeTipo) { this.nomeTipo = nomeTipo; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
}