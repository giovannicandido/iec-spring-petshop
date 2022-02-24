package com.example.petshop.service;

import com.example.petshop.repository.ReportRepository;
import com.example.petshop.repository.projections.ServicoPorClientReport;
import com.example.petshop.resources.request.ServicoPorClienteRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportService {
    @Autowired
    private ReportRepository reportRepository;

    public List<ServicoPorClientReport> servicoPorClientReport(ServicoPorClienteRequest request) {
        return reportRepository.servicoPorClientReportGroupBy(request);
    }
}
