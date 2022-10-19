package com.usa.doctorsapp.repository;


import com.usa.doctorsapp.model.Motorbike;
import com.usa.doctorsapp.repository.crudrepository.MotorbikeCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class MotorbikeRepository {

    @Autowired
    private MotorbikeCrudRepository motorbikeCrudRepository;

    public List<Motorbike> getAll(){
        return (List<Motorbike>) motorbikeCrudRepository.findAll();
    }

    public Optional<Motorbike> getById(Integer idDoctor){
        return motorbikeCrudRepository.findById(idDoctor);
    }

    public Motorbike save(Motorbike motorbike){
        return motorbikeCrudRepository.save(motorbike);
    }

    public void delete(Motorbike motorbike){
        motorbikeCrudRepository.delete(motorbike);
    }
}
