package com.brighter.api.BrigherCodeBot7.twitter;

import org.springframework.web.client.RestTemplate;

public class TwitterHttpEndpoint {

    protected static final String BASE_TWITTER_API_URI = "https://api.twitter.com/";
    protected final RestTemplate rt;

    public TwitterHttpEndpoint(RestTemplate rt) {
        this.rt = rt;
    }
}
