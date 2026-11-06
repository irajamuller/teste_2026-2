package com.finance.cotacoes.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.finance.cotacoes.service.CotacoesService;

@RestController
@RequestMapping("/cotacoes")
public class CotacoesController {
	
	@Autowired
	private CotacoesService cotacoesService;
	
	@GetMapping
	public BigDecimal get() {
		return cotacoesService.get();
	}

}
