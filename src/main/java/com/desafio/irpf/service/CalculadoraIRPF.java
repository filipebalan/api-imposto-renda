package com.desafio.irpf.service;

import com.desafio.irpf.model.Pessoa;
import com.desafio.irpf.model.ResultadoIRPF;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class CalculadoraIRPF {

    private static final BigDecimal LIMITE_FAIXA_1 = new BigDecimal("2259.20");
    private static final BigDecimal LIMITE_FAIXA_2 = new BigDecimal("2826.65");
    private static final BigDecimal LIMITE_FAIXA_3 = new BigDecimal("3751.05");
    private static final BigDecimal LIMITE_FAIXA_4 = new BigDecimal("4664.68");

    public ResultadoIRPF calcular(Pessoa pessoa) {
        // Se a pessoa não mandar a renda, assumimos zero para não dar erro
        BigDecimal salario = pessoa.getRendaSalarial() != null ? pessoa.getRendaSalarial() : BigDecimal.ZERO;

        if (salario.compareTo(LIMITE_FAIXA_1) <= 0) {
            return new ResultadoIRPF("Até R$ 2.259,20", "Isento", BigDecimal.ZERO);
        } else if (salario.compareTo(LIMITE_FAIXA_2) <= 0) {
            BigDecimal imposto = calcularValor(salario, "0.075", "169.44");
            return new ResultadoIRPF("De R$ 2.259,21 até R$ 2.826,65", "7,5%", imposto);
        } else if (salario.compareTo(LIMITE_FAIXA_3) <= 0) {
            BigDecimal imposto = calcularValor(salario, "0.15", "381.44");
            return new ResultadoIRPF("De R$ 2.826,66 até R$ 3.751,05", "15%", imposto);
        } else if (salario.compareTo(LIMITE_FAIXA_4) <= 0) {
            BigDecimal imposto = calcularValor(salario, "0.225", "662.77");
            return new ResultadoIRPF("De R$ 3.751,06 até R$ 4.664,68", "22,5%", imposto);
        } else {
            BigDecimal imposto = calcularValor(salario, "0.275", "896.00");
            return new ResultadoIRPF("Acima de R$ 4.664,68", "27,5%", imposto);
        }
    }

    private BigDecimal calcularValor(BigDecimal salario, String aliquota, String deducao) {
        BigDecimal valorAliquota = new BigDecimal(aliquota);
        BigDecimal valorDeducao = new BigDecimal (deducao);
        return salario.multiply(valorAliquota).subtract(valorDeducao).setScale(2, RoundingMode.HALF_UP);
    }
}