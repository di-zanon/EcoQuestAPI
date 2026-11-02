package br.com.fiap.ecoquestapi.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

@Entity
@Table(name = "TB_TRANSACAO")
public class Transacao {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_transacao")
    @SequenceGenerator(name = "seq_transacao", sequenceName = "SEQ_TRANSACAO", allocationSize = 1)
    @Column(name = "ID_TRANSACAO")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "id_acao")
    private AcaoSustentavel acao;

    @NotNull
    @Column(nullable = false)
    private Character tipo; // 'C' para Crédito, 'D' para Débito

    @NotNull
    @Column(nullable = false)
    private Integer valor;

    private LocalDate dataTransacao = LocalDate.now();

    private String motivo;

    // Construtor vazio
    public Transacao() {}

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Usuario getUsuario() { return usuario; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }

    public AcaoSustentavel getAcao() { return acao; }
    public void setAcao(AcaoSustentavel acao) { this.acao = acao; }

    public Character getTipo() { return tipo; }
    public void setTipo(Character tipo) { this.tipo = tipo; }

    public Integer getValor() { return valor; }
    public void setValor(Integer valor) { this.valor = valor; }

    public LocalDate getDataTransacao() { return dataTransacao; }
    public void setDataTransacao(LocalDate dataTransacao) { this.dataTransacao = dataTransacao; }

    public String getMotivo() { return motivo; }
    public void setMotivo(String motivo) { this.motivo = motivo; }
}