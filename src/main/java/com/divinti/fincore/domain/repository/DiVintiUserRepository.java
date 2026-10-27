package com.divinti.fincore.domain.repository;
import com.divinti.fincore.domain.model.DiVintiUser;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
public interface DiVintiUserRepository extends JpaRepository<DiVintiUser, Long> {
    Optional<DiVintiUser> findByEmail(String email);
}