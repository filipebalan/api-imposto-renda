package com.desafio.irpf.service;

import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class CalculoIrpfService {

    // Valor fixo de dedução por dependente vigente
    private static final BigDecimal DEDUCAO_DEPENDENTE = new BigDecimal("189.59");

    public BigDecimal calcular(BigDecimal rendimentoBruto, BigDecimal inss, Integer dependentes) {
        // 1. NOVA REGRA DE ISENÇÃO: Renda até R$ 5.000,00 zera o imposto direto
        if (rendimentoBruto.compareTo(new BigDecimal("5000.00")) <= 0) {
            return BigDecimal.ZERO.setScale(2, RoundingMode.HALF_UP);
        }

        // 2. Calcular o desconto total por dependentes
        BigDecimal descontoDependentes = DEDUCAO_DEPENDENTE.multiply(new BigDecimal(dependentes));

        // 3. Calcular a Base de Cálculo: Rendimento - INSS - Dependentes
        BigDecimal baseCalculo = rendimentoBruto.subtract(inss).subtract(descontoDependentes);

        if (baseCalculo.compareTo(BigDecimal.ZERO) <= 0) {
            return BigDecimal.ZERO.setScale(2, RoundingMode.HALF_UP);
        }

        // 4. Aplicar a Tabela Progressiva Atualizada
        BigDecimal imposto;

        if (baseCalculo.compareTo(new BigDecimal("2428.80")) <= 0) {
            imposto = BigDecimal.ZERO;
        } else if (baseCalculo.compareTo(new BigDecimal("2826.65")) <= 0) {
            // Alíquota 7,5% - Parcela a deduzir R$ 182,16
            imposto = baseCalculo.multiply(new BigDecimal("0.075")).subtract(new BigDecimal("182.16"));
        } else if (baseCalculo.compareTo(new BigDecimal("3751.05")) <= 0) {
            // Alíquota 15% - Parcela a deduzir R$ 394,16
            imposto = baseCalculo.multiply(new BigDecimal("0.15")).subtract(new BigDecimal("394.16"));
        } else if (baseCalculo.compareTo(new BigDecimal("4664.68")) <= 0) {
            // Alíquota 22,5% - Parcela a deduzir R$ 675,49
            imposto = baseCalculo.multiply(new BigDecimal("0.225")).subtract(new BigDecimal("675.49"));
        } else {
            // Alíquota 27,5% - Parcela a deduzir R$ 908,73
            imposto = baseCalculo.multiply(new BigDecimal("0.275")).subtract(new BigDecimal("908.73"));
        }

        if (imposto.compareTo(BigDecimal.ZERO) < 0) {
            imposto = BigDecimal.ZERO;
        }

        // 5. NOVA REGRA DE REDUÇÃO PARCIAL (Rendas entre R$ 5.000,01 e R$ 7.350,00)
        if (rendimentoBruto.compareTo(new BigDecimal("7350.00")) <= 0 && imposto.compareTo(BigDecimal.ZERO) > 0) {
            // Fórmula legal: 978,62 - (0,133145 * renda mensal)
            BigDecimal fatorReducao = rendimentoBruto.multiply(new BigDecimal("0.133145"));
            BigDecimal reducao = new BigDecimal("978.62").subtract(fatorReducao);

            if (reducao.compareTo(BigDecimal.ZERO) > 0) {
                imposto = imposto.subtract(reducao);
                if (imposto.compareTo(BigDecimal.ZERO) < 0) {
                    imposto = BigDecimal.ZERO;
                }
            }
        }

        return imposto.setScale(2, RoundingMode.HALF_UP);
    }
}