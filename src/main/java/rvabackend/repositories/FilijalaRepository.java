package rvabackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import rvabackend.models.Filijala;

import java.util.List;

public interface FilijalaRepository extends JpaRepository<Filijala, Integer>{
    List<Filijala> findByBankaId(Integer bankaId);
    List<Filijala> findByAdresaContainingIgnoreCase(String adresa);
}
