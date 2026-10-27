package com.divinti.fincore.service;

import com.divinti.fincore.api.dto.DiVintiTransferRequest;
import com.divinti.fincore.domain.enums.DiVintiTransactionType;
import com.divinti.fincore.domain.model.DiVintiTransaction;
import com.divinti.fincore.domain.repository.DiVintiAccountRepository;
import com.divinti.fincore.domain.repository.DiVintiTransactionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
public class DiVintiTransferService {
    private final DiVintiAccountRepository accountRepo;
    private final DiVintiTransactionRepository txRepo;
    private final DiVintiAuditService audit;
    public DiVintiTransferService(DiVintiAccountRepository a, DiVintiTransactionRepository t, DiVintiAuditService au){
        this.accountRepo=a; this.txRepo=t; this.audit=au;
    }
    @Transactional
    public DiVintiTransaction transfer(DiVintiTransferRequest req){
        if(req.getAmount().compareTo(BigDecimal.ZERO) <= 0) throw new RuntimeException("Valor invalido");
        var from = accountRepo.findByAccountNumber(req.getFromAccountNumber()).orElseThrow();
        var to = accountRepo.findByAccountNumber(req.getToAccountNumber()).orElseThrow();
        if(from.getBalance().compareTo(req.getAmount()) < 0) throw new RuntimeException("Saldo insuficiente DiVinti");
        from.setBalance(from.getBalance().subtract(req.getAmount()));
        to.setBalance(to.getBalance().add(req.getAmount()));
        accountRepo.save(from); accountRepo.save(to);
        
        DiVintiTransaction tx = new DiVintiTransaction();
        tx.setFromAccount(from); tx.setToAccount(to); tx.setAmount(req.getAmount());
        tx.setType(DiVintiTransactionType.TRANSFER); tx.setDescription(req.getDescription());
        tx.setCreatedAt(LocalDateTime.now());
        audit.log("TRANSFER", from.getAccountNumber(), "R$"+req.getAmount()+" -> "+to.getAccountNumber());
        return txRepo.save(tx);
    }
}