package rvabackend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rvabackend.models.Usluga;
import rvabackend.repositories.UslugaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class UslugaService {

    @Autowired
    private UslugaRepository uslugaRepository;

    public List<Usluga> getAll() {
        return uslugaRepository.findAll();
    }

    public Optional<Usluga> getById(Integer id) {
        return uslugaRepository.findById(id);
    }

    public Usluga save(Usluga usluga) {
        return uslugaRepository.save(usluga);
    }

    public void deleteById(Integer id) {
        uslugaRepository.deleteById(id);
    }

    public List<Usluga> getByFilijalaId(Integer filijalaId) {
        return uslugaRepository.findByFilijalaId(filijalaId);
    }

    public List<Usluga> getByKorisnikId(Integer korisnikId) {
        return uslugaRepository.findByKorisnikId(korisnikId);
    }

    public List<Usluga> getByBankaId(Integer bankaId) {
        return uslugaRepository.findByFilijala_Banka_Id(bankaId);
    }

    public List<Usluga> searchByNaziv(String naziv) {
        return uslugaRepository.findByNazivContainingIgnoreCase(naziv);
    }

    public List<Usluga> getAfterDate(LocalDate datum) {
        return uslugaRepository.findByDatumUgovoraAfter(datum);
    }

    public List<Usluga> getBetweenDates(LocalDate from, LocalDate to) {
        return uslugaRepository.findByDatumUgovoraBetween(from, to);
    }
}