package com.desafio.irpf.repository;

import com.desafio.irpf.model.Declaracao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeclaracaoRepository extends JpaRepository<Declaracao, Long> {
}