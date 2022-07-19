package com.brighter.api.BrigherCodeBot7;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;

@SpringBootApplication
public class BrigherCodeBot7Application {

	public static void main(String[] args) {
		SpringApplication.run(BrigherCodeBot7Application.class, args);
	}

	@Bean
	public Twitter twitter(){
		return new TwitterFactory().getInstance();
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}
}
