package com.desafio.irpf.repository;

import com.desafio.irpf.model.Declaracao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DeclaracaoRepository extends JpaRepository<Declaracao, Long> {

    List<Declaracao> findAllByUsuarioIdOrderByDataCalculoDesc(Long usuarioId);

}