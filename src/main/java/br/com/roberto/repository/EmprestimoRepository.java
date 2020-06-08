package br.com.roberto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.roberto.model.Emprestimo;

@Repository
public interface EmprestimoRepository extends JpaRepository<Emprestimo, Long>{

}
