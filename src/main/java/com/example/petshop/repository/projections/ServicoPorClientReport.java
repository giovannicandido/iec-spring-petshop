package com.example.petshop.repository.projections;

import java.util.Date;
import java.util.List;

public class ServicoPorClientReport {
    private String emailPessoa;
    private String nomePessoa;
    private String descricaoServico;
    private Date dataEntrada;
    private Date dataSaida;
    private String nomeProduto;
    private Double precoProduto;
    private String nomePet;
    private List<ProdutoDto> produtos;

    public ServicoPorClientReport(String emailPessoa, String nomePessoa, String descricaoServico,
                                  Date dataEntrada, Date dataSaida,
                                  String nomeProduto, Double precoProduto, String nomePet) {
        this.emailPessoa = emailPessoa;
        this.nomePessoa = nomePessoa;
        this.descricaoServico = descricaoServico;
        this.dataEntrada = dataEntrada;
        this.dataSaida = dataSaida;
        this.nomeProduto = nomeProduto;
        this.precoProduto = precoProduto;
        this.nomePet = nomePet;
    }

    public ServicoPorClientReport(String emailPessoa, String nomePessoa, String descricaoServico,
                                  Date dataEntrada, Date dataSaida,
                                  List<ProdutoDto> produtos, String nomePet) {
        this.emailPessoa = emailPessoa;
        this.nomePessoa = nomePessoa;
        this.descricaoServico = descricaoServico;
        this.dataEntrada = dataEntrada;
        this.dataSaida = dataSaida;
        this.produtos = produtos;
        this.nomePet = nomePet;
    }

    public String getEmailPessoa() {
        return emailPessoa;
    }

    public void setEmailPessoa(String emailPessoa) {
        this.emailPessoa = emailPessoa;
    }

    public String getNomePessoa() {
        return nomePessoa;
    }

    public void setNomePessoa(String nomePessoa) {
        this.nomePessoa = nomePessoa;
    }

    public Date getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(Date dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public Date getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(Date dataSaida) {
        this.dataSaida = dataSaida;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public Double getPrecoProduto() {
        return precoProduto;
    }

    public void setPrecoProduto(Double precoProduto) {
        this.precoProduto = precoProduto;
    }

    public String getNomePet() {
        return nomePet;
    }

    public void setNomePet(String nomePet) {
        this.nomePet = nomePet;
    }

    public String getDescricaoServico() {
        return descricaoServico;
    }

    public void setDescricaoServico(String descricaoServico) {
        this.descricaoServico = descricaoServico;
    }

    public List<ProdutoDto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<ProdutoDto> produtos) {
        this.produtos = produtos;
    }
}
