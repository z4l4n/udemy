package com.example.ChickenClub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@ConfigurationPropertiesScan
public class ChickenClubApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChickenClubApplication.class, args);
	}

}
