package com.desafio.irpf.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class HomeController {

    @GetMapping("/")
    public Map<String, String> boasVindas() {
        var resposta = new HashMap<String, String>();
        resposta.put("status", "Online");
        resposta.put("serviço", "API de Cálculo de IRPF 2026");
        resposta.put("mensagem", "Bem-vindo! Para testar os endpoints, utilize o Insomnia ou acesse a documentação em /swagger-ui.html");
        resposta.put("autor", "Filipe Balan");
        return resposta;
    }
}