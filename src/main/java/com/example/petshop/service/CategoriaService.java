package com.example.petshop.service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

import com.example.petshop.domain.Categoria;
import com.example.petshop.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.example.petshop.service.exceptions.DataIntegrityException;
import com.example.petshop.service.exceptions.ObjetoNaoEncontradoException;
import org.springframework.transaction.support.TransactionTemplate;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository repo;

	@Autowired
	private TransactionTemplate transactionTemplate;

	public List<Categoria> findAll() {
		return repo.findAll();
	}

	public Categoria find(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		return obj.orElseThrow( () -> new ObjetoNaoEncontradoException( "Objeto não encontrado. ID: " + id + ", Tipo: " + Categoria.class.getName()));
	}
	
	public Categoria insert(Categoria obj) {
		obj.setId(null);
		Categoria retorno = transactionTemplate.execute(status -> {
			return repo.save(obj);
		});
		return retorno;
	}
	
	public Categoria update(Categoria obj) {
		return transactionTemplate.execute(status -> {
			find(obj.getId());
			return repo.save(obj);
		});

	}	
	
	public void delete(Integer id) {
		find(id);		
		try {
			transactionTemplate.executeWithoutResult(status -> {
				repo.deleteById(id);
			});

		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Categoria possui produtos, não é possível deletar!");
		}
		
	}

}
