package com.divinti.fincore.service;

import com.divinti.fincore.domain.model.DiVintiAccount;
import com.divinti.fincore.domain.repository.DiVintiAccountRepository;
import org.springframework.stereotype.Service;
import java.util.UUID;

@Service
public class DiVintiAccountService {
    private final DiVintiAccountRepository repo;
    private final DiVintiAuditService audit;
    public DiVintiAccountService(DiVintiAccountRepository repo, DiVintiAuditService audit){
        this.repo=repo; this.audit=audit;
    }
    public DiVintiAccount create(DiVintiAccount acc){
        acc.setAccountNumber("DIVINTI-"+UUID.randomUUID().toString().substring(0,6).toUpperCase());
        DiVintiAccount saved = repo.save(acc);
        audit.log("ACCOUNT_CREATED","SYSTEM","Conta: "+saved.getAccountNumber());
        return saved;
    }
    public DiVintiAccount findByNumber(String number){
        return repo.findByAccountNumber(number).orElseThrow(()->new RuntimeException("Conta nao encontrada"));
    }
}