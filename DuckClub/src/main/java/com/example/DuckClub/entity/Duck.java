package com.example.DuckClub.entity;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import org.hibernate.annotations.Generated;

@Entity
@Data
public class Duck {

    @Id
    @GeneratedValue
    private long id;

    private String name;

    private int weight;

    @JsonAlias("isMale")
    @JsonProperty("isMale")
    private boolean isMale;

}
