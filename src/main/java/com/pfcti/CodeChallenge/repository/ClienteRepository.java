package com.pfcti.CodeChallenge.repository;

import com.pfcti.CodeChallenge.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente,Integer> {

}
