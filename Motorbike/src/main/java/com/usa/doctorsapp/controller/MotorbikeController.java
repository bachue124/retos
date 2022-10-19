package com.usa.doctorsapp.controller;

import com.usa.doctorsapp.model.Motorbike;
import com.usa.doctorsapp.service.MotorbikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Motorbike")
@CrossOrigin(origins = "*",methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class MotorbikeController {

    @Autowired
    private MotorbikeService motorService;

    @GetMapping("/all")
    public List<Motorbike> getMotorbikes() {
        return motorService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Motorbike> getMotorbike(@PathVariable ("id") Integer id) {
        return motorService.getById(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Motorbike save(@RequestBody Motorbike motorbike) {
        return motorService.save(motorbike);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Motorbike update(@RequestBody Motorbike motorbike) {
        return motorService.update(motorbike);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable ("id") Integer id) {
        return motorService.delete(id);
    }
}
