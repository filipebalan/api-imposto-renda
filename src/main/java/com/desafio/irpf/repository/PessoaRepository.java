package com.desafio.irpf.repository;

import com.desafio.irpf.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // Diz pro Spring assumir o controle dessa interface
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
    // Vazio mesmo! O JpaRepository já tem todo o código SQL escrito por trás dos panos.
}