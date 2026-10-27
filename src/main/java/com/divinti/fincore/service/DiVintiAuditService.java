package com.divinti.fincore.service;

import com.divinti.fincore.domain.model.DiVintiAuditLog;
import com.divinti.fincore.domain.repository.DiVintiAuditLogRepository;
import org.springframework.stereotype.Service;

@Service
public class DiVintiAuditService {
    private final DiVintiAuditLogRepository repo;
    public DiVintiAuditService(DiVintiAuditLogRepository repo){ this.repo = repo; }
    
    public void log(String action, String by, String details){
        DiVintiAuditLog log = new DiVintiAuditLog();
        log.setAction("DIVINTI_"+action);
        log.setPerformedBy(by);
        log.setDetails(details);
        repo.save(log);
    }
}