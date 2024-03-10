package com.example.Gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
	}


	@Bean
	public RouteLocator myRoutes(RouteLocatorBuilder builder) {
		return builder.routes()
				.route(p -> p
						.path("/ilaapps/chickenclub/**")
						.filters(f -> f.rewritePath("/ilaapps/chickenclub?(?<segment>.*)", "${segment}"))
						.uri("lb://chickenclub"))
				.route(p -> p
						.path("/ilaapps/duck/**")
						.filters(f -> f.rewritePath("/ilaapps/duck?(?<segment>.*)", "${segment}").circuitBreaker(cb -> cb.setName("chickBreaker")))
						.uri("lb://duck"))
				.build();
	}

}
