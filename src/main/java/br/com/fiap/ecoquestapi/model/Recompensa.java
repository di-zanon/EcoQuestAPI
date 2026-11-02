package br.com.fiap.ecoquestapi.model;

import jakarta.persistence.*;

@Entity
@Table(name = "TB_RECOMPENSA")
public class Recompensa {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_recompensa")
    @SequenceGenerator(name = "seq_recompensa", sequenceName = "SEQ_RECOMPENSA", allocationSize = 1)
    @Column(name = "ID_RECOMPENSA")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ID_TIPO_RECOMPENSA", nullable = false)
    private TipoRecompensa tipoRecompensa;

    @Column(nullable = false)
    private String descricao;

    @Column(name = "PONTOS_NECESSARIOS", nullable = false)
    private Integer pontosNecessarios;

    public Recompensa() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public TipoRecompensa getTipoRecompensa() { return tipoRecompensa; }
    public void setTipoRecompensa(TipoRecompensa tipoRecompensa) { this.tipoRecompensa = tipoRecompensa; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public Integer getPontosNecessarios() { return pontosNecessarios; }
    public void setPontosNecessarios(Integer pontosNecessarios) { this.pontosNecessarios = pontosNecessarios; }
}
