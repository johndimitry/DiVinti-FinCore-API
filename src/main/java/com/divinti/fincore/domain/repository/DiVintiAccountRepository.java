package com.divinti.fincore.domain.repository;
import com.divinti.fincore.domain.model.DiVintiAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
public interface DiVintiAccountRepository extends JpaRepository<DiVintiAccount, Long> {
    Optional<DiVintiAccount> findByAccountNumber(String number);
}