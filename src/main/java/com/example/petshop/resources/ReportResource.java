package com.example.petshop.resources;

import com.example.petshop.repository.projections.ServicoPorClientReport;
import com.example.petshop.resources.request.ServicoPorClienteRequest;
import com.example.petshop.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/report")
public class ReportResource {
    @Autowired
    private ReportService reportService;

    @PostMapping(path = "/servico-por-cliente")
    public List<ServicoPorClientReport> servicoPorClientReport(@RequestBody ServicoPorClienteRequest request) {
        return reportService.servicoPorClientReport(request);
    }
}
