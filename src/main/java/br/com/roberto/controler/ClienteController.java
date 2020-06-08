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

import br.com.roberto.model.Cliente;
import br.com.roberto.repository.ClienteRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;



@Api(value = "Cliente Endpoint", tags = "Cliente Endpoint")
@RestController
@RequestMapping("/api/cliente/v1")
public class ClienteController {

	
	
	@Autowired
	private ClienteRepository repository;

	@ApiOperation(value = "Busca todos os Clientes")
	@GetMapping
	public List<Cliente> fundByAll() {
		return repository.findAll();

	}

	@ApiOperation(value = "Deleta um Cliente por id")
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {
		repository.deleteById(id);
		return ResponseEntity.ok().build();
	}

	@ApiOperation(value = "Busca um cliente por id")
	@GetMapping(value = "/{id}")
	public Optional<Cliente> fundById(@PathVariable("id") Long id) {
		return repository.findById(id);
	}

	@ApiOperation(value = "Cadastra um cliente por id")
	@PostMapping()
	public Cliente create(@RequestBody Cliente cliente) {
		return repository.save(cliente);
	}
	@ApiOperation(value = "Atualiza um cliente por id")
	@PutMapping
	public Cliente update(@RequestBody Cliente cliente) {
		var entity = repository.findById(cliente.getId()).orElse(cliente);
				
		entity.setNome(cliente.getNome());
		entity.setBairro(cliente.getBairro());
		entity.setCep(cliente.getCep());
		entity.setCidade(cliente.getCidade());
		entity.setCpf(cliente.getCpf());
		entity.setDataNascimento(cliente.getDataNascimento());
		entity.setEndereco(cliente.getEndereco());
		entity.setEstado(cliente.getEstado());
		entity.setId(cliente.getId());
		entity.setRg(cliente.getRg());
		entity.setTelefone(cliente.getTelefone());;
		
		return repository.save(entity);
	}
}
