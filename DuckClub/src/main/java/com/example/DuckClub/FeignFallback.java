package com.example.DuckClub;

import com.example.DuckClub.entity.Chicken;
import org.springframework.stereotype.Component;

@Component
public class FeignFallback implements FeignService{
    @Override
    public Chicken getChickenById(long id) {
        Chicken c = new Chicken();
        c.setName("fallbackChick!");
        return c;
    }
}
