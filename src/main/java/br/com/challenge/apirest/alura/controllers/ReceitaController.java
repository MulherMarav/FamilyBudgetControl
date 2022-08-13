package br.com.challenge.apirest.alura.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.challenge.apirest.alura.services.ReceitaService;
import br.com.challenge.apirest.alura.util.MediaType;
import br.com.challenge.apirest.alura.vo.ReceitaVO;

@RestController
@RequestMapping("/budget-control/receitas")
public class ReceitaController {

	@Autowired
	private ReceitaService service;

	@PostMapping(consumes = { MediaType.APPLICATION_JSON }, produces = { MediaType.APPLICATION_JSON })
	public ReceitaVO create(@RequestBody ReceitaVO receitaVO) {
		return service.create(receitaVO);
	}

	@GetMapping(produces = { MediaType.APPLICATION_JSON })
	public List<ReceitaVO> findAll() {
		return service.findAll();
	}

	@GetMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON })
	public ReceitaVO findById(@PathVariable(value = "id") Integer id) {
		return service.findById(id);
	}

	@PutMapping(value = "/{id}", consumes = { MediaType.APPLICATION_JSON }, produces = { MediaType.APPLICATION_JSON })
	public ReceitaVO update(@PathVariable(value = "id") Integer id, @RequestBody ReceitaVO receitaVO) {
		return service.update(id, receitaVO);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> delete(@PathVariable(value = "id") Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping(value = "/{descricao}", produces = { MediaType.APPLICATION_JSON })
	public List<ReceitaVO> findByDescricao(@PathVariable(value = "descricao") String descricao) {
		return service.findByDescricao(descricao);
	}
}
