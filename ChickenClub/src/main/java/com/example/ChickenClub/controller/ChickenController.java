package com.example.ChickenClub.controller;

import com.example.ChickenClub.entity.Chicken;
import com.example.ChickenClub.entity.ChickenConfig;
import com.example.ChickenClub.repository.ChickenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/api")
public class ChickenController {

    @Autowired
    private ChickenConfig config;

    @Autowired
    private ChickenRepository chickenRepository;

    @GetMapping("/chicken/{id}")
    public Chicken getChickenById(@PathVariable("id") long id)  {
        return chickenRepository.findById(id).orElseThrow(() -> new RuntimeException("No chicken found"));
    }

    @GetMapping("/chicken/hi")
    public String getChickHi()  {
        return config.getHi();


    }

    @PostMapping("/chicken")
    public Chicken createChicken(@RequestBody Chicken chicken) {
        return chickenRepository.save(chicken);
    }
}
