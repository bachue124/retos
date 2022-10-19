package com.usa.doctorsapp.service;

import com.usa.doctorsapp.model.Motorbike;
import com.usa.doctorsapp.repository.MotorbikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MotorbikeService {

    @Autowired
    private MotorbikeRepository motorbikeRepository;

    public List<Motorbike> getAll() {
        return motorbikeRepository.getAll();
    }

    public Optional<Motorbike> getById(Integer id) {
        return motorbikeRepository.getById(id);
    }

    public Motorbike save(Motorbike motorbike){
        if(motorbike.getId()==null){
            return motorbikeRepository.save(motorbike);
        } else {
            Optional<Motorbike> optionalMotorbike= motorbikeRepository.getById(motorbike.getId());
            if(optionalMotorbike.isEmpty()){
                return motorbikeRepository.save(motorbike);
            } else {
                return motorbike;
            }
        }
    }

    public Motorbike update(Motorbike motorbike){
        if(motorbike.getId()!=null){
            Optional<Motorbike> optionalDoctor= motorbikeRepository.getById(motorbike.getId());
            if(!optionalDoctor.isEmpty()){
                if(motorbike.getName()!=null){
                    optionalDoctor.get().setName(motorbike.getName());
                }
                if(motorbike.getBrand()!=null){
                    optionalDoctor.get().setBrand(motorbike.getBrand());
                }
                if(motorbike.getYear()!=null){
                    optionalDoctor.get().setYear(motorbike.getYear());
                }
                if(motorbike.getDescription()!=null){
                    optionalDoctor.get().setDescription(motorbike.getDescription());
                }
                if(motorbike.getCategory()!=null){
                    optionalDoctor.get().setCategory(motorbike.getCategory());
                }
                motorbikeRepository.save(optionalDoctor.get());
                return optionalDoctor.get();
            } else {
                return motorbike;
            }
        } else {
            return motorbike;
        }
    }

    public boolean delete(Integer id){
        Boolean aBoolean=getById(id).map(doctor -> {
            motorbikeRepository.delete(doctor);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
