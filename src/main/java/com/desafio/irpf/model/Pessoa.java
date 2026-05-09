package com.desafio.irpf.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.math.BigDecimal;

@Entity
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String email;
    private String documento;
    private String telefone;
    private String endereco;
    private BigDecimal rendaSalarial;
    private String regimeDeTrabalho;

    // Construtor vazio (Obrigatório para o Spring Data JPA funcionar)
    public Pessoa() {
    }

    // --- Daqui para baixo são os Getters e Setters ---

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public BigDecimal getRendaSalarial() {
        return rendaSalarial;
    }

    public void setRendaSalarial(BigDecimal rendaSalarial) {
        this.rendaSalarial = rendaSalarial;
    }

    public String getRegimeDeTrabalho() {
        return regimeDeTrabalho;
    }

    public void setRegimeDeTrabalho(String regimeDeTrabalho) {
        this.regimeDeTrabalho = regimeDeTrabalho;
    }
}