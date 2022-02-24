package com.example.petshop.repository;

import com.example.petshop.domain.Produto;
import com.example.petshop.domain.QCategoria;
import com.example.petshop.domain.QProduto;
import com.example.petshop.dto.ProdutoDTO;
import com.example.petshop.resources.request.ProdutoPesquisaRequest;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;

import javax.persistence.EntityManager;
import java.util.List;

public class CustomProdutoRepositoryImpl implements CustomProdutoRepository{

    private final JPAQueryFactory queryFactory;

    private final QProduto produto = QProduto.produto;
    private final QCategoria categoria = QCategoria.categoria;

    public CustomProdutoRepositoryImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }

    @Override
    public List<ProdutoDTO> search(ProdutoPesquisaRequest request) {
        JPAQuery<ProdutoDTO> query = queryFactory.from(produto)
                .innerJoin(produto.categorias, categoria)
                .select(Projections.constructor(ProdutoDTO.class,
                        produto.id,
                        produto.nome,
                        produto.preco,
                        categoria.id));

        if (request.getNome() != null) {
            query.where(produto.nome.startsWithIgnoreCase(request.getNome()));
        }

        if (request.getCategoriaIds() != null) {
            query.where(categoria.id.in(request.getCategoriaIds()));
        }

        return query.fetch();
    }
}
