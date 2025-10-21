package rvabackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import rvabackend.models.Usluga;

import java.time.LocalDate;
import java.util.List;

public interface UslugaRepository extends JpaRepository<Usluga, Integer> {

    List<Usluga> findByFilijalaId(Integer filijalaId);

    List<Usluga> findByKorisnikId(Integer korisnikId);

    List<Usluga> findByFilijala_Banka_Id(Integer bankaId);

    List<Usluga> findByNazivContainingIgnoreCase(String naziv);

    List<Usluga> findByDatumUgovoraAfter(LocalDate datum);

    List<Usluga> findByDatumUgovoraBetween(LocalDate from, LocalDate to);
}