package rvabackend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rvabackend.models.KorisnikUsluge;
import rvabackend.services.KorisnikUslugeService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/korisnik")
@CrossOrigin
public class KorisnikUslugeController {

    @Autowired
    private KorisnikUslugeService korisnikUslugeService;

    @GetMapping
    public ResponseEntity<List<KorisnikUsluge>> getAllKorisnici() {
        List<KorisnikUsluge> korisnici = korisnikUslugeService.getAll();
        return ResponseEntity.ok(korisnici);
    }

    @GetMapping("/{id}")
    public ResponseEntity<KorisnikUsluge> getKorisnikById(@PathVariable Integer id) {
        Optional<KorisnikUsluge> korisnik = korisnikUslugeService.getById(id);

        if (korisnik.isPresent()) {
            return ResponseEntity.ok(korisnik.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/search/ime")
    public ResponseEntity<List<KorisnikUsluge>> searchByIme(@RequestParam String ime) {
        List<KorisnikUsluge> korisnici = korisnikUslugeService.searchByIme(ime);
        return ResponseEntity.ok(korisnici);
    }

    @GetMapping("/search/prezime")
    public ResponseEntity<List<KorisnikUsluge>> searchByPrezime(@RequestParam String prezime) {
        List<KorisnikUsluge> korisnici = korisnikUslugeService.searchByPrezime(prezime);
        return ResponseEntity.ok(korisnici);
    }

    @GetMapping("/maticni/{maticniBroj}")
    public ResponseEntity<KorisnikUsluge> getByMaticniBroj(@PathVariable String maticniBroj) {
        KorisnikUsluge korisnik = korisnikUslugeService.getByMaticniBroj(maticniBroj);

        if (korisnik != null) {
            return ResponseEntity.ok(korisnik);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<KorisnikUsluge> createKorisnik(@RequestBody KorisnikUsluge korisnik) {
        KorisnikUsluge savedKorisnik = korisnikUslugeService.save(korisnik);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedKorisnik);
    }

    @PutMapping("/{id}")
    public ResponseEntity<KorisnikUsluge> updateKorisnik(
            @PathVariable Integer id,
            @RequestBody KorisnikUsluge korisnik) {

        Optional<KorisnikUsluge> existingKorisnik = korisnikUslugeService.getById(id);

        if (existingKorisnik.isPresent()) {
            korisnik.setId(id);
            KorisnikUsluge updatedKorisnik = korisnikUslugeService.save(korisnik);
            return ResponseEntity.ok(updatedKorisnik);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteKorisnik(@PathVariable Integer id) {
        Optional<KorisnikUsluge> korisnik = korisnikUslugeService.getById(id);

        if (korisnik.isPresent()) {
            korisnikUslugeService.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}