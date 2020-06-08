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

import br.com.roberto.model.User;
import br.com.roberto.repository.UserRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;




@Api(value = "User Endpoint", tags = "User Endpoint")
@RestController
@RequestMapping("/api/user/v1")
public class UserController {
	
	
	@Autowired
	private UserRepository repository;

	@ApiOperation(value = "Busca todos os User")
	@GetMapping
	public List<User> fundByAll() {
		return repository.findAll();

	}

	@ApiOperation(value = "Deleta um User por id")
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {
		repository.deleteById(id);
		return ResponseEntity.ok().build();
	}

	@ApiOperation(value = "Busca um User por id")
	@GetMapping(value = "/{id}")
	public Optional<User> fundById(@PathVariable("id") Long id) {
		return repository.findById(id);
	}

	@ApiOperation(value = "Cadastra um User por id")
	@PostMapping()
	public User create(@RequestBody User user) {
		return repository.save(user);
	}
	@ApiOperation(value = "Atualiza um User por id")
	@PutMapping
	public User update(@RequestBody User user) {
		var entity = repository.findById(user.getId()).orElse(user);
		entity.setId(user.getId());
		entity.setPasword(user.getPasword());
		entity.setUserName(user.getUserName());
		
		return repository.save(entity);
	}
}
