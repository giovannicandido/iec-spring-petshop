package com.example.petshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.petshop.domain.Pessoa;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Integer>{

}
