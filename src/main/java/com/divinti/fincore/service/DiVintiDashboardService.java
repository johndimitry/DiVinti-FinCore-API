package com.divinti.fincore.service;

import com.divinti.fincore.domain.repository.DiVintiAccountRepository;
import com.divinti.fincore.domain.repository.DiVintiClientRepository;
import com.divinti.fincore.domain.repository.DiVintiTransactionRepository;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Service
public class DiVintiDashboardService {
    private final DiVintiAccountRepository accountRepo;
    private final DiVintiTransactionRepository txRepo;
    private final DiVintiClientRepository clientRepo;

    public DiVintiDashboardService(DiVintiAccountRepository accountRepo, DiVintiTransactionRepository txRepo, DiVintiClientRepository clientRepo){
        this.accountRepo = accountRepo;
        this.txRepo = txRepo;
        this.clientRepo = clientRepo;
    }

    public Map<String,Object> getDashboard(){
        Map<String,Object> m = new HashMap<>();
        m.put("brand","DiVinti FinCore");
        m.put("colors","Vermelho #E30613 / Preto #000000 / Branco #FFFFFF");
        m.put("totalAccounts", accountRepo.count());
        m.put("totalClients", clientRepo.count());
        m.put("totalTransactions", txRepo.count());
        BigDecimal total = accountRepo.findAll().stream().map(a->a.getBalance()).reduce(BigDecimal.ZERO, BigDecimal::add);
        m.put("totalBalance", total);
        return m;
    }
}