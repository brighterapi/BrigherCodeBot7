package com.brighter.api.BrigherCodeBot7;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

@SpringBootApplication
public class BrigherCodeBot7Application {

	@Value("${oauth.consumerKey}")
	private String consumerKey;

	@Value("${oauth.consumerSecret}")
	private String consumerSecret;

	@Value("${oauth.accessToken}")
	private String accessToken;

	@Value("${oauth.accessTokenSecret}")
	private String accessTokenSecret;

	public static void main(String[] args) {
		SpringApplication.run(BrigherCodeBot7Application.class, args);
	}

	@Bean
	public Twitter twitter(){
		ConfigurationBuilder cb = new ConfigurationBuilder();
		cb.setDebugEnabled(true)
				.setOAuthConsumerKey(consumerKey)
				.setOAuthConsumerSecret(consumerSecret)
				.setOAuthAccessToken(accessToken)
				.setOAuthAccessTokenSecret(accessTokenSecret);
		return new TwitterFactory(cb.build()).getInstance();
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}
}
