package rvabackend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rvabackend.models.Usluga;
import rvabackend.services.UslugaService;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usluga")
@CrossOrigin
public class UslugaController {

    @Autowired
    private UslugaService uslugaService;

    @GetMapping
    public ResponseEntity<List<Usluga>> getAllUsluge() {
        List<Usluga> usluge = uslugaService.getAll();
        return ResponseEntity.ok(usluge);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usluga> getUslugaById(@PathVariable Integer id) {
        Optional<Usluga> usluga = uslugaService.getById(id);

        if (usluga.isPresent()) {
            return ResponseEntity.ok(usluga.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/filijala/{filijalaId}")
    public ResponseEntity<List<Usluga>> getUslugeByFilijala(@PathVariable Integer filijalaId) {
        List<Usluga> usluge = uslugaService.getByFilijalaId(filijalaId);
        return ResponseEntity.ok(usluge);
    }

    @GetMapping("/korisnik/{korisnikId}")
    public ResponseEntity<List<Usluga>> getUslugeByKorisnik(@PathVariable Integer korisnikId) {
        List<Usluga> usluge = uslugaService.getByKorisnikId(korisnikId);
        return ResponseEntity.ok(usluge);
    }

    @GetMapping("/banka/{bankaId}")
    public ResponseEntity<List<Usluga>> getUslugeByBanka(@PathVariable Integer bankaId) {
        List<Usluga> usluge = uslugaService.getByBankaId(bankaId);
        return ResponseEntity.ok(usluge);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Usluga>> searchUsluge(@RequestParam String naziv) {
        List<Usluga> usluge = uslugaService.searchByNaziv(naziv);
        return ResponseEntity.ok(usluge);
    }

    @GetMapping("/after")
    public ResponseEntity<List<Usluga>> getUslugeAfterDate(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate datum) {
        List<Usluga> usluge = uslugaService.getAfterDate(datum);
        return ResponseEntity.ok(usluge);
    }

    @GetMapping("/between")
    public ResponseEntity<List<Usluga>> getUslugeBetweenDates(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate from,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate to) {
        List<Usluga> usluge = uslugaService.getBetweenDates(from, to);
        return ResponseEntity.ok(usluge);
    }

    @PostMapping
    public ResponseEntity<Usluga> createUsluga(@RequestBody Usluga usluga) {
        Usluga savedUsluga = uslugaService.save(usluga);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedUsluga);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usluga> updateUsluga(
            @PathVariable Integer id,
            @RequestBody Usluga usluga) {

        Optional<Usluga> existingUsluga = uslugaService.getById(id);

        if (existingUsluga.isPresent()) {
            usluga.setId(id);
            Usluga updatedUsluga = uslugaService.save(usluga);
            return ResponseEntity.ok(updatedUsluga);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUsluga(@PathVariable Integer id) {
        Optional<Usluga> usluga = uslugaService.getById(id);

        if (usluga.isPresent()) {
            uslugaService.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}