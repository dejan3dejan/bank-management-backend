package rvabackend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rvabackend.models.Banka;
import rvabackend.repositories.BankaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class BankaService {

    @Autowired
    private BankaRepository bankaRepository;

    public List<Banka> getAll(){
        return bankaRepository.findAll();
    }

    public Optional<Banka> getById(Integer id){
        return bankaRepository.findById(id);
    }

    public Banka save(Banka banka){
        return bankaRepository.save(banka);
    }

    public void deleteById(Integer id){
        bankaRepository.deleteById(id);
    }
}
