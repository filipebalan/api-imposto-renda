package com.desafio.irpf.controller;

import com.desafio.irpf.model.Usuario;
import com.desafio.irpf.repository.UsuarioRepository;
import com.desafio.irpf.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class AutenticacaoController {

    @Autowired
    private UsuarioRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // Injetamos as novas ferramentas de Login e Token
    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;

    public record DadosRegistro(String login, String senha) {}
    public record DadosLogin(String login, String senha) {}

    // --- ROTA DE CADASTRO (Já testada) ---
    @PostMapping("/usuarios")
    public ResponseEntity<String> cadastrar(@RequestBody DadosRegistro dados) {
        if (repository.findByLogin(dados.login()) != null) {
            return ResponseEntity.badRequest().body("Erro: Este login já está em uso!");
        }

        String senhaCriptografada = passwordEncoder.encode(dados.senha());
        Usuario novoUsuario = new Usuario(dados.login(), senhaCriptografada);
        repository.save(novoUsuario);

        return ResponseEntity.ok("Usuário cadastrado com sucesso!");
    }

    // --- NOVA ROTA DE LOGIN ---
    @PostMapping("/login")
    public ResponseEntity<String> efetuarLogin(@RequestBody DadosLogin dados) {
        // 1. Monta o pacote com o login e a senha digitados
        var authenticationToken = new UsernamePasswordAuthenticationToken(dados.login(), dados.senha());

        // 2. O Spring vai lá no banco, puxa a hash BCrypt e compara sozinha
        var authentication = manager.authenticate(authenticationToken);

        // 3. Se a senha bater, geramos o crachá digital (JWT)
        var tokenJWT = tokenService.gerarToken((Usuario) authentication.getPrincipal());

        // 4. Devolvemos o token pronto na resposta
        return ResponseEntity.ok(tokenJWT);
    }

    // --- ROTA PROTEGIDA (O Teste do Cadeado) ---
    @GetMapping("/teste-seguranca")
    public ResponseEntity<String> testeCadeado() {
        return ResponseEntity.ok("Porta aberta! O Spring Security reconheceu seu Token JWT com sucesso.");
    }
}