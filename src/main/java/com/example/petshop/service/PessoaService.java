package com.example.petshop.service;

import java.util.List;
import java.util.Optional;

import com.example.petshop.domain.Pessoa;
import com.example.petshop.repository.PessoaRepository;
import com.example.petshop.service.exceptions.ObjetoNaoEncontradoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.example.petshop.service.exceptions.DataIntegrityException;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

@Service
public class PessoaService {
	
	@Autowired
	private PessoaRepository repo;

	@Autowired
	private PlatformTransactionManager transactionManager;
	
	public Pessoa find(Integer id) {
		Optional<Pessoa> obj = repo.findById(id);
		return obj.orElseThrow( () -> new ObjetoNaoEncontradoException( "Objeto não encontrado. ID: " + id + ", Tipo: " + Pessoa.class.getName()));
	}
	
	public Pessoa insert(Pessoa obj) {
		obj.setId(null);
		DefaultTransactionDefinition definition = new DefaultTransactionDefinition();
		definition.setTimeout(30);
		TransactionStatus status = transactionManager.getTransaction(definition);
		try {

			Pessoa retorno = repo.save(obj);
			transactionManager.commit(status);
			return retorno;
		} catch (Exception ex) {
			transactionManager.rollback(status);
			return null;
		}
	}
	
	public Pessoa update(Pessoa obj) {
		find(obj.getId());
		return repo.save(obj);
	}	
	
	public void delete(Integer id) {
		find(id);		
		try {
			repo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Pessoa não pode ser deletada!");
		}		
	}

	public List<Pessoa> findAll() {		
		return repo.findAll();
	}

}
