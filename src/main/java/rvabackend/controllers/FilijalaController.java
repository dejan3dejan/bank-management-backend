package rvabackend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rvabackend.models.Filijala;
import rvabackend.services.FilijalaService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/filijala")
@CrossOrigin
public class FilijalaController  {

    @Autowired
    private FilijalaService filijalaService;

    @GetMapping
    public ResponseEntity<List<Filijala>> getAllFilijale(){
        List<Filijala> filijale = filijalaService.getAll();
        return ResponseEntity.ok(filijale);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Filijala> getFilijalaById(@PathVariable Integer id){
        Optional<Filijala> filijala = filijalaService.getById(id);

        if (filijala.isPresent()) {
            return ResponseEntity.ok(filijala.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/banka/{bankaId}")
    public ResponseEntity<List<Filijala>> getFilijalaByBankaId(@PathVariable Integer bankaId){
        List<Filijala> filijala = filijalaService.getByBankaId(bankaId);
        return ResponseEntity.ok(filijala);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Filijala>> searchFilijala(@RequestParam String adresa){
        List<Filijala> filijala = filijalaService.searchByAdresa(adresa);
        return ResponseEntity.ok(filijala);
    }

    @PostMapping
    public ResponseEntity<Filijala> createFilijala(@RequestBody Filijala filijala){
        Filijala savedFilijala = filijalaService.save(filijala);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedFilijala);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Filijala> updateFilijala(@PathVariable Integer id, @RequestBody Filijala filijala){

        Optional<Filijala> existingFilijala = filijalaService.getById(id);

        if (existingFilijala.isPresent()) {
            filijala.setId(id);
            Filijala updatedFilijala = filijalaService.save(filijala);
            return ResponseEntity.ok(updatedFilijala);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Filijala> deleteFilijala(@PathVariable Integer id){
        Optional<Filijala> existingFilijala = filijalaService.getById(id);

        if (existingFilijala.isPresent()) {
            filijalaService.deleteById(id);
            return ResponseEntity.ok(existingFilijala.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
