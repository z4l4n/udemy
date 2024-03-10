package com.example.DuckClub;

import com.example.DuckClub.entity.Chicken;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "chickenclub", fallback = FeignFallback.class)
public interface FeignService {

        @GetMapping("api/chicken/{id}")
        public Chicken getChickenById(@PathVariable("id") long id);


}
