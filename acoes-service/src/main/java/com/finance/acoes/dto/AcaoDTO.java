package com.finance.acoes.dto;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.UUID;

import com.finance.acoes.model.Acao;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AcaoDTO {
	private UUID id;
	private String nome;
	private String codigo;
	private Integer qtdeAcoes;
	private BigDecimal precoUnitario;
	private BigDecimal vlrReal;
	private BigDecimal vlrDolar;
	
	public static AcaoDTO from(Acao acao, BigDecimal precoDolar) {
		return AcaoDTO.builder()
					.codigo(acao.getCodigo())
					.id(acao.getId())
					.nome(acao.getNome())
					.precoUnitario(acao.getPrecoUnitario())
					.qtdeAcoes(acao.getQtdeAcoes())
					.vlrReal(acao.getPrecoUnitario().multiply(BigDecimal.valueOf(acao.getQtdeAcoes()), MathContext.DECIMAL128))
					.vlrDolar(acao.getPrecoUnitario().multiply(BigDecimal.valueOf(acao.getQtdeAcoes()), MathContext.DECIMAL128).divide(precoDolar, MathContext.DECIMAL128))
					.build();
	}
}
