package com.example.ChickenClub.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "chicken")
@Getter
@Setter
public class ChickenConfig {
    private String hi;
}
