package com.example.ChickenClub.entity;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Chicken {

    @Id
    @GeneratedValue
    private long id;

    private String name;

    private int weight;

    @JsonAlias("isMale")
    @JsonProperty("isMale")
    private boolean isMale;

}
