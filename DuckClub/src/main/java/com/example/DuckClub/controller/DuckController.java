package com.example.DuckClub.controller;

import com.example.DuckClub.FeignService;
import com.example.DuckClub.entity.Chicken;
import com.example.DuckClub.entity.Duck;
import com.example.DuckClub.entity.DuckConfig;
import com.example.DuckClub.repository.DuckRepository;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/api")
@Slf4j
public class DuckController {

    @Autowired
    private FeignService feignService;
    @Autowired
    private DuckConfig config;

    @Autowired
    private DuckRepository duckRepository;

    @GetMapping("/duck/{id}")
    public Duck getDuckById(@PathVariable("id") long id)  {
        return duckRepository.findById(id).orElseThrow(() -> new RuntimeException("No duck found"));
    }

    @GetMapping("/duck/chicken/{id}")
    public Chicken getChickenById(@PathVariable("id") long id)  {
        return feignService.getChickenById(id);
    }

    @Retry(name = "thi", fallbackMethod = "dog")
    @GetMapping("/duck/hi")
    public String getDuckHi()  {
       return "duckhi!";
    }

    public String dog(Throwable throwable)  {
       return "fallbackTretry";
    }

    @PostMapping("/duck")
    public Duck createDuck(@RequestBody Duck duck) {
        return duckRepository.save(duck);
    }



}
