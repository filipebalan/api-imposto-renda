package com.desafio.irpf.model;

import java.math.BigDecimal;

public class ResultadoIRPF {
    private String faixaSalarial;
    private String aliquotaAplicada;
    private BigDecimal impostoAPagar;

    public ResultadoIRPF(String faixaSalarial, String aliquotaAplicada, BigDecimal impostoAPagar) {
        this.faixaSalarial = faixaSalarial;
        this.aliquotaAplicada = aliquotaAplicada;
        this.impostoAPagar = impostoAPagar;
    }

    // Getters para a API conseguir ler os resultados
    public String getFaixaSalarial() { return faixaSalarial; }
    public String getAliquotaAplicada() { return aliquotaAplicada; }
    public BigDecimal getImpostoAPagar() { return impostoAPagar; }
}