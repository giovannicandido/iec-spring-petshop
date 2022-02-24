package com.example.petshop.resources.request;

import java.util.List;

public class ProdutoPesquisaRequest {
    private String nome;
    private List<Integer> categoriaIds;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Integer> getCategoriaIds() {
        return categoriaIds;
    }

    public void setCategoriaIds(List<Integer> categoriaIds) {
        this.categoriaIds = categoriaIds;
    }
}
