package com.example.petshop.service;

import com.example.petshop.dto.ProdutoDTO;
import com.example.petshop.repository.ProdutoRepository;
import com.example.petshop.resources.request.ProdutoPesquisaRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    private final ProdutoRepository repository;

    public ProdutoService(ProdutoRepository repository) {
        this.repository = repository;
    }

    public List<ProdutoDTO> search(ProdutoPesquisaRequest request) {
        return repository.search(request);
    }
}
