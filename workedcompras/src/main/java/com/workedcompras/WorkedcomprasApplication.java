package com.workedcompras;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@EnableRabbit
@SpringBootApplication
public class WorkedcomprasApplication {

	public static void main(String[] args) {
		SpringApplication.run(WorkedcomprasApplication.class, args);
	}

}
