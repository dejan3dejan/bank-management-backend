package rvabackend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rvabackend.models.Banka;
import rvabackend.services.BankaService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/banka")
@CrossOrigin
public class BankaController {

    @Autowired
    private BankaService bankaService;

    @GetMapping
    public ResponseEntity<List<Banka>> getAllBanke(){
        List<Banka> banke = bankaService.getAll();
        return ResponseEntity.ok(banke); // 200 + JSON
    }

    @GetMapping("/{id}")
    public ResponseEntity<Banka> getBankaById(@PathVariable Integer id){
        Optional<Banka> banka = bankaService.getById(id);

        if (banka.isPresent()){
            return ResponseEntity.ok(banka.get()); // 200 + JSON
        } else {
            return ResponseEntity.notFound().build(); //404
        }
    }

    @PostMapping
    public ResponseEntity<Banka> createBanka(@RequestBody Banka banka){
        Banka savedBanka = bankaService.save(banka);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedBanka); //201
    }

    @PutMapping("/{id}")
    public ResponseEntity<Banka> updateBanka(@PathVariable Integer id, @RequestBody Banka banka){

        Optional<Banka> existingBanka = bankaService.getById(id);

        if (existingBanka.isPresent()){
            banka.setId(id);
            Banka updatedBanka = bankaService.save(banka);
            return ResponseEntity.ok(updatedBanka); // 200
        } else {
            return ResponseEntity.notFound().build(); // 404
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBanka(@PathVariable Integer id){
        Optional<Banka> banka = bankaService.getById(id);

        if (banka.isPresent()){
            bankaService.deleteById(id);
            return ResponseEntity.ok().build(); // 200
        } else {
            return ResponseEntity.notFound().build(); // 404
        }
    }
}
