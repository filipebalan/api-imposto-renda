package com.desafio.irpf.controller;

import com.desafio.irpf.model.Pessoa;
import com.desafio.irpf.model.ResultadoIRPF;
import com.desafio.irpf.service.CalculadoraIRPF;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

@RestController
@RequestMapping("/api/imposto")
@CrossOrigin(origins = "*")
public class IrpfController {

   private final CalculadoraIRPF calculadora;

   public IrpfController(CalculadoraIRPF calculadora) {
        this.calculadora = calculadora;
    }

    @PostMapping("/calcular")
    public ResultadoIRPF calcularImposto(@RequestBody Pessoa pessoa) {
        // Recebe os dados da pessoa e manda para a calculadora fazer a mágica
        return calculadora.calcular(pessoa);
    }
}
