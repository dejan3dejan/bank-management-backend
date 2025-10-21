package rvabackend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rvabackend.models.Filijala;
import rvabackend.repositories.FilijalaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class FilijalaService {

    @Autowired
    private FilijalaRepository filijalaRepository;

    public List<Filijala> getAll(){
        return filijalaRepository.findAll();
    }

    public Optional<Filijala> getById(Integer id){
        return filijalaRepository.findById(id);
    }

    public Filijala save(Filijala filijala){
        return filijalaRepository.save(filijala);
    }

    public void deleteById(Integer id){
        filijalaRepository.deleteById(id);
    }

    public List<Filijala> getByBankaId(Integer bankaId){
        return filijalaRepository.findByBankaId(bankaId);
    }

    public List<Filijala> searchByAdresa(String adresa){
        return filijalaRepository.findByAdresaContainingIgnoreCase(adresa);
    }
}
