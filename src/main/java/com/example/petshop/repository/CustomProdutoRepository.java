package com.example.petshop.repository;

import com.example.petshop.dto.ProdutoDTO;
import com.example.petshop.resources.request.ProdutoPesquisaRequest;

import java.util.List;

public interface CustomProdutoRepository {
    List<ProdutoDTO> search(ProdutoPesquisaRequest request);
}
