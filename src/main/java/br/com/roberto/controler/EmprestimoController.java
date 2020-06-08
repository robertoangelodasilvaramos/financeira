package br.com.roberto.controler;

import java.util.List;
import java.util.Optional;

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

import br.com.roberto.model.Emprestimo;
import br.com.roberto.repository.EmprestimoRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "Emprestimo Endpoint", tags = "Emprestimo Endpoint")
@RestController
@RequestMapping("/api/emprestimo/v1")
public class EmprestimoController {

	@Autowired
	private EmprestimoRepository repository;

	@ApiOperation(value = "Busca todos os emprestimos")
	@GetMapping
	public List<Emprestimo> fundByAll() {
		return repository.findAll();

	}

	@ApiOperation(value = "Deleta um Emprestimo por id")
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {
		repository.deleteById(id);
		return ResponseEntity.ok().build();
	}

	@ApiOperation(value = "Busca um Emprestimo por id")
	@GetMapping(value = "/{id}")
	public Optional<Emprestimo> fundById(@PathVariable("id") Long id) {
		return repository.findById(id);
	}

	@ApiOperation(value = "Cadastra um Emprestimo por id")
	@PostMapping()
	public Emprestimo create(@RequestBody Emprestimo emprestimo) {
		return repository.save(emprestimo);
	}
	@ApiOperation(value = "Atualiza um Emprestimo por id")
	@PutMapping
	public Emprestimo update(@RequestBody Emprestimo emprestimo) {
		var entity = repository.findById(emprestimo.getId()).orElse(emprestimo);
				
		entity.setNome(emprestimo.getNome());
		entity.setId(emprestimo.getId());
		entity.setDataFinanciamento(emprestimo.getDataFinanciamento());
		entity.setDataTerminoFinanciamento(emprestimo.getDataTerminoFinanciamento());
		entity.setDescricao(emprestimo.getDescricao());
		entity.setParcelas(emprestimo.getParcelas());
		entity.setValor(emprestimo.getValor());
		
		return repository.save(entity);
	}
}
