package com.cricket.fantasy_cricket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class FantasyCricketApplication {

	public static void main(String[] args) {
		SpringApplication.run(FantasyCricketApplication.class, args);
	}

}
