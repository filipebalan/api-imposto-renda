package com.desafio.irpf.repository;

import com.desafio.irpf.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    // Trocamos UserDetails por Usuario aqui para casar perfeitamente com o JPA!
    Usuario findByLogin(String login);
}