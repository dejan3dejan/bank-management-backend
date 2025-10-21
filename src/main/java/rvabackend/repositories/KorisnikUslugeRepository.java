package rvabackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import rvabackend.models.KorisnikUsluge;

import java.util.List;

public interface KorisnikUslugeRepository extends JpaRepository<KorisnikUsluge, Integer> {

    List<KorisnikUsluge> findByImeContainingIgnoreCase(String ime);

    List<KorisnikUsluge> findByPrezimeContainingIgnoreCase(String prezime);

    KorisnikUsluge findByMaticniBroj(String maticniBroj);
}