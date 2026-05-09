package com.desafio.irpf.controller;

import com.desafio.irpf.model.Pessoa;
import com.desafio.irpf.model.ResultadoIRPF;
import com.desafio.irpf.repository.PessoaRepository; // <-- Importante
import com.desafio.irpf.service.CalculadoraIRPF;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/imposto")
@CrossOrigin(origins = "*")
public class IrpfController {

    private final CalculadoraIRPF calculadora;
    private final PessoaRepository pessoaRepository; // 1. Declaramos a ferramenta do banco

    // 2. Colocamos o repository dentro do construtor para o Spring injetá-lo
    public IrpfController(CalculadoraIRPF calculadora, PessoaRepository pessoaRepository) {
        this.calculadora = calculadora;
        this.pessoaRepository = pessoaRepository;
    }

    @PostMapping("/calcular")
    public ResultadoIRPF calcularImposto(@RequestBody Pessoa pessoa) {

        // 3. A MÁGICA ACONTECE AQUI: Salva os dados no PostgreSQL!
        pessoaRepository.save(pessoa);

        // 4. Continua a vida normalmente, fazendo o cálculo matemático e devolvendo pro front-end
        return calculadora.calcular(pessoa);
    }
}