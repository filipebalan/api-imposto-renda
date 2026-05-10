package com.desafio.irpf.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "declaracoes")
public class Declaracao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "rendimento_bruto", nullable = false)
    private BigDecimal rendimentoBruto;

    @Column(name = "desconto_inss", nullable = false)
    private BigDecimal descontoInss;

    @Column(name = "numero_dependentes", nullable = false)
    private Integer numeroDependentes;

    @Column(name = "imposto_devido")
    private BigDecimal impostoDevido;

    @Column(name = "data_calculo")
    private LocalDateTime dataCalculo = LocalDateTime.now();

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    // Construtor padrão obrigatório para o JPA
    public Declaracao() {}

    // Construtor para facilitar a criação via código
    public Declaracao(BigDecimal rendimentoBruto, BigDecimal descontoInss, Integer numeroDependentes, Usuario usuario) {
        this.rendimentoBruto = rendimentoBruto;
        this.descontoInss = descontoInss;
        this.numeroDependentes = numeroDependentes;
        this.usuario = usuario;
    }

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public BigDecimal getRendimentoBruto() { return rendimentoBruto; }
    public void setRendimentoBruto(BigDecimal rendimentoBruto) { this.rendimentoBruto = rendimentoBruto; }

    public BigDecimal getDescontoInss() { return descontoInss; }
    public void setDescontoInss(BigDecimal descontoInss) { this.descontoInss = descontoInss; }

    public Integer getNumeroDependentes() { return numeroDependentes; }
    public void setNumeroDependentes(Integer numeroDependentes) { this.numeroDependentes = numeroDependentes; }

    public BigDecimal getImpostoDevido() { return impostoDevido; }
    public void setImpostoDevido(BigDecimal impostoDevido) { this.impostoDevido = impostoDevido; }

    public LocalDateTime getDataCalculo() { return dataCalculo; }
    public void setDataCalculo(LocalDateTime dataCalculo) { this.dataCalculo = dataCalculo; }

    public Usuario getUsuario() { return usuario; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }

}