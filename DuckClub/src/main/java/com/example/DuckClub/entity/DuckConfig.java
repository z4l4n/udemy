package com.example.DuckClub.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "duck")
@Getter
@Setter
public class DuckConfig {
    private String hi;
}
