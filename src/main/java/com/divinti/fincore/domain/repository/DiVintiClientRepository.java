package com.divinti.fincore.domain.repository;
import com.divinti.fincore.domain.model.DiVintiClient;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
public interface DiVintiClientRepository extends JpaRepository<DiVintiClient, Long> {
    Optional<DiVintiClient> findByCpf(String cpf);
}
