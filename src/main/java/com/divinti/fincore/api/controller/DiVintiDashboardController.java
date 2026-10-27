package com.divinti.fincore.api.controller;

import java.math.BigDecimal;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.divinti.fincore.ai.DiVintiInsightService;
import com.divinti.fincore.service.DiVintiDashboardService;

@RestController @RequestMapping("/api/divinti/dashboard")
public class DiVintiDashboardController {
    private final DiVintiDashboardService dashboardService;
    private final DiVintiInsightService insightService;

    public DiVintiDashboardController(DiVintiDashboardService dashboardService, DiVintiInsightService insightService){
        this.dashboardService=dashboardService;
        this.insightService=insightService;
    }

    @GetMapping public Map<String,Object> dashboard(){ return dashboardService.getDashboard(); }
    
    @PostMapping("/insights") public String insights(@RequestBody Map<String,BigDecimal> gastos){ 
        try { return insightService.explain(gastos); } 
        catch(Exception e){ return insightService.explainFallback(gastos); }
    }
}