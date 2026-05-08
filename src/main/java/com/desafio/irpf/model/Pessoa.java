package com.desafio.irpf.model;

 import java.math.BigDecimal;

 public class Pessoa {
     private String nome;
     private String email;
     private String documento;
     private String telefone;
     private String endereço;
     private BigDecimal rendaSalarial;
     private String regimeDeTrabalho;

     // Métodos para pegar e colocar os dados (Getters e Setters)
     public BigDecimal getRendaSalarial() {
         return rendaSalarial;
     }

     public void setRendaSalarial(BigDecimal rendaSalarial) {
         this.rendaSalarial = rendaSalarial;
     }

     // Para simplificar agora, deixei apenas o getter/setter da renda que é o que usaremos no cálculo!
 }