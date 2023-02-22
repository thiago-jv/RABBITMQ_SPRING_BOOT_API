package com.worker.validador;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@EnableRabbit
@SpringBootApplication
public class ValidadorApplication {

	public static void main(String[] args) {
		SpringApplication.run(ValidadorApplication.class, args);
	}

}
