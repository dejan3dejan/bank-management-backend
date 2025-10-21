package rvabackend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rvabackend.models.KorisnikUsluge;
import rvabackend.repositories.KorisnikUslugeRepository;

import java.util.List;
import java.util.Optional;

@Service
public class KorisnikUslugeService {

    @Autowired
    private KorisnikUslugeRepository korisnikUslugeRepository;

    public List<KorisnikUsluge> getAll() {
        return korisnikUslugeRepository.findAll();
    }

    public Optional<KorisnikUsluge> getById(Integer id) {
        return korisnikUslugeRepository.findById(id);
    }

    public KorisnikUsluge save(KorisnikUsluge korisnik) {
        return korisnikUslugeRepository.save(korisnik);
    }

    public void deleteById(Integer id) {
        korisnikUslugeRepository.deleteById(id);
    }

    public List<KorisnikUsluge> searchByIme(String ime) {
        return korisnikUslugeRepository.findByImeContainingIgnoreCase(ime);
    }

    public List<KorisnikUsluge> searchByPrezime(String prezime) {
        return korisnikUslugeRepository.findByPrezimeContainingIgnoreCase(prezime);
    }

    public KorisnikUsluge getByMaticniBroj(String maticniBroj) {
        return korisnikUslugeRepository.findByMaticniBroj(maticniBroj);
    }
}