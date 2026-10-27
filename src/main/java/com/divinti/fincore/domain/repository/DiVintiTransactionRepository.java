package com.divinti.fincore.domain.repository;
import com.divinti.fincore.domain.model.DiVintiTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
public interface DiVintiTransactionRepository extends JpaRepository<DiVintiTransaction, Long> {}
