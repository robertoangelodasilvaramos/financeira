package br.com.roberto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.roberto.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
