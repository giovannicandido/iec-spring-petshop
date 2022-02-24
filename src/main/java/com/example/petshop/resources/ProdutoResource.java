package com.example.petshop.resources;

import com.example.petshop.resources.request.ProdutoPesquisaRequest;
import com.example.petshop.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/produto")
public class ProdutoResource {
    @Autowired
    private ProdutoService service;

    @RequestMapping(value = "/pesquisar", method = RequestMethod.POST)
    public ResponseEntity<?> pesquisar(@RequestBody ProdutoPesquisaRequest request) {
        return ResponseEntity.ok().body(service.search(request));
    }
}
