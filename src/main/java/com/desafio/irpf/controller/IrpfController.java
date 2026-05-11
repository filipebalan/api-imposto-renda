package com.desafio.irpf.controller;

import com.desafio.irpf.dto.DeclaracaoHistoricoDTO;
import com.desafio.irpf.model.Declaracao;
import com.desafio.irpf.model.Usuario;
import com.desafio.irpf.repository.DeclaracaoRepository;
import com.desafio.irpf.service.CalculoIrpfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/irpf")
public class IrpfController {

    @Autowired
    private CalculoIrpfService calculoService;

    @Autowired
    private DeclaracaoRepository declaracaoRepository;

    @Autowired
    private DeclaracaoRepository repository;

    // DTO limpo para receber os dados
    public record DadosCalculo(BigDecimal rendimentoBruto, BigDecimal descontoInss, Integer numeroDependentes) {}

    @PostMapping("/calcular")
    public ResponseEntity<BigDecimal> calcular(@RequestBody DadosCalculo dados, @AuthenticationPrincipal Usuario logado) {

        // 1. Processa a lógica matemática com as regras atualizadas
        BigDecimal imposto = calculoService.calcular(dados.rendimentoBruto(), dados.descontoInss(), dados.numeroDependentes());

        // 2. Salva no banco relacionando com o usuário logado
        Declaracao declaracao = new Declaracao(dados.rendimentoBruto(), dados.descontoInss(), dados.numeroDependentes(), logado);
        declaracao.setImpostoDevido(imposto);

        repository.save(declaracao);

        // 3. Retorna o valor final
        return ResponseEntity.ok(imposto);
    }

    @GetMapping("/historico")
    public ResponseEntity<List<DeclaracaoHistoricoDTO>> listarHistorico(@AuthenticationPrincipal Usuario usuario) {
        var historico = declaracaoRepository.findAllByUsuarioIdOrderByDataCalculoDesc(usuario.getId())
                .stream()
                .map(DeclaracaoHistoricoDTO::doModel)
                .toList();

        return ResponseEntity.ok(historico);
    }

}