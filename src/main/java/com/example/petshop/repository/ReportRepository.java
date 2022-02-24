package com.example.petshop.repository;

import com.example.petshop.domain.*;
import com.example.petshop.repository.projections.ProdutoDto;
import com.example.petshop.repository.projections.ServicoPorClientReport;
import com.example.petshop.resources.request.ServicoPorClienteRequest;
import com.querydsl.core.ResultTransformer;
import com.querydsl.core.group.GroupBy;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

import static com.querydsl.core.group.GroupBy.groupBy;

@Repository
public class ReportRepository {
    private final JPAQueryFactory queryFactory;

    private final QServico servico = QServico.servico;
    private final QCliente cliente = QCliente.cliente;
    private final QProduto produto = QProduto.produto;
    private final QPet pet = QPet.pet;

    public ReportRepository(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }

    public List<ServicoPorClientReport> servicoPorClientReport(ServicoPorClienteRequest request) {
        JPAQuery<ServicoPorClientReport> query = queryFactory.from(servico)
                .innerJoin(servico.cliente, cliente)
                .leftJoin(servico.produtos, produto)
                .innerJoin(servico.pet, pet)
                .select(Projections.constructor(ServicoPorClientReport.class,
                        cliente.email,
                        cliente.nome,
                        servico.descricao,
                        servico.dataEntrada,
                        servico.dataSaida,
                        produto.nome,
                        produto.preco,
                        pet.nome
                ));

        if (request.getIdCliente() != null) {
            query.where(cliente.id.eq(request.getIdCliente()));
        }

        if(request.getDataEntradaDe() != null && request.getDataEntradaAte() != null) {
            query.where(servico.dataEntrada.between(request.getDataEntradaDe(), request.getDataEntradaAte()));
        } else if(request.getDataEntradaAte() != null) {
            query.where(servico.dataEntrada.before(request.getDataEntradaAte()));

        }else if(request.getDataEntradaDe() != null) {
            query.where(servico.dataEntrada.after(request.getDataEntradaDe()));
        }

        return query.fetch();

    }

    public List<ServicoPorClientReport> servicoPorClientReportGroupBy(ServicoPorClienteRequest request) {
        JPAQuery query = queryFactory.from(servico)
                .innerJoin(servico.cliente, cliente)
                .leftJoin(servico.produtos, produto)
                .innerJoin(servico.pet, pet);

        if (request.getIdCliente() != null) {
            query.where(cliente.id.eq(request.getIdCliente()));
        }

        if(request.getDataEntradaDe() != null && request.getDataEntradaAte() != null) {
            query.where(servico.dataEntrada.between(request.getDataEntradaDe(), request.getDataEntradaAte()));
        } else if(request.getDataEntradaAte() != null) {
            query.where(servico.dataEntrada.before(request.getDataEntradaAte()));

        }else if(request.getDataEntradaDe() != null) {
            query.where(servico.dataEntrada.after(request.getDataEntradaDe()));
        }

        List<ServicoPorClientReport> result = (List<ServicoPorClientReport>) query.transform(
                groupBy(servico.id)
                        .list(Projections.constructor(ServicoPorClientReport.class,
                                cliente.email,
                                cliente.nome,
                                servico.descricao,
                                servico.dataEntrada,
                                servico.dataSaida,
                                GroupBy.list(Projections.constructor(
                                        ProdutoDto.class,
                                        produto.nome, produto.preco
                                )),
                                pet.nome
                        )));

        return result;

    }

}
