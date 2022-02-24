package com.example.petshop.resources.request;

import java.util.Date;

public class ServicoPorClienteRequest {
    private Integer idCliente;
    private Date dataEntradaDe;
    private Date dataEntradaAte;

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public Date getDataEntradaDe() {
        return dataEntradaDe;
    }

    public void setDataEntradaDe(Date dataEntradaDe) {
        this.dataEntradaDe = dataEntradaDe;
    }

    public Date getDataEntradaAte() {
        return dataEntradaAte;
    }

    public void setDataEntradaAte(Date dataEntradaAte) {
        this.dataEntradaAte = dataEntradaAte;
    }
}
