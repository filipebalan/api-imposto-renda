package com.desafio.irpf.dto;

import com.desafio.irpf.model.Declaracao;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public record DeclaracaoHistoricoDTO(
        BigDecimal rendimentoBruto,
        BigDecimal descontoInss,
        Integer numeroDependentes,
        LocalDateTime dataCalculo
) {
    // Esse método transforma a Declaracao (do banco) no DTO (pro usuário)
    public static DeclaracaoHistoricoDTO doModel(Declaracao declaracao) {
        return new DeclaracaoHistoricoDTO(
                declaracao.getRendimentoBruto(),
                declaracao.getDescontoInss(),
                declaracao.getNumeroDependentes(),
                declaracao.getDataCalculo()
        );
    }
}