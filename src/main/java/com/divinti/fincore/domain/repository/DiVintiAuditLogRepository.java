package com.divinti.fincore.domain.repository;
import com.divinti.fincore.domain.model.DiVintiAuditLog;
import org.springframework.data.jpa.repository.JpaRepository;
public interface DiVintiAuditLogRepository extends JpaRepository<DiVintiAuditLog, Long> {}