package com.finance.acoes.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.finance.acoes.dto.AcaoDTO;
import com.finance.acoes.model.Acao;
import com.finance.acoes.service.AcoesService;

@RestController
@RequestMapping("/acoes")
public class AcoesController {
	
	@Autowired
	private AcoesService acoesService;
	
	@GetMapping
	public List<AcaoDTO> getAll(@RequestParam(required = false) String codigo) {
		return acoesService.getAll(codigo);
	}

	@PostMapping
	public Acao save(@RequestBody Acao acao) {
		return acoesService.save(acao);
	}
	@DeleteMapping("/{id}")
	public void delete(@PathVariable UUID id) {
		acoesService.delete(id);
	}
}
