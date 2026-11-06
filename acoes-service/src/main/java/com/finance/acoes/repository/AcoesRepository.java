package com.finance.acoes.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.finance.acoes.model.Acao;
import java.util.List;


@Repository
public interface AcoesRepository extends JpaRepository<Acao, UUID> {
	List<Acao> findByCodigo(String codigo);
}
