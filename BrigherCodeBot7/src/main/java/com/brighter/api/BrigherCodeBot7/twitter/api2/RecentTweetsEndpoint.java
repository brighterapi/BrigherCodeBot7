package com.brighter.api.BrigherCodeBot7.twitter.api2;

import com.brighter.api.BrigherCodeBot7.converter.RecentTweetsConverter;
import com.brighter.api.BrigherCodeBot7.domain.Tweet;
import com.brighter.api.BrigherCodeBot7.domain.http.recentsearch.RecentSearchResponse;
import com.brighter.api.BrigherCodeBot7.twitter.TwitterApi2Endpoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Component
public class RecentTweetsEndpoint extends TwitterApi2Endpoint {
    private static final Logger logger = LoggerFactory.getLogger(RecentTweetsEndpoint.class);
    public static final String BASE_QUERY_RECENT_TWEETS = BASE_TWITTER_API_2_URI + "tweets/search/recent?tweet.fields=author_id,lang&query=";

    private final RecentTweetsConverter recentTweetsConverter;
    private final HttpEntity<RecentSearchResponse> recentTweetsResponseEntity;

    @Autowired
    public RecentTweetsEndpoint(RestTemplate rt, RecentTweetsConverter recentTweetsConverter, @Value("${bearerToken}") String bearerToken) {
        super(rt, bearerToken);
        this.recentTweetsConverter = recentTweetsConverter;
        final HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer " + this.bearerToken);

        recentTweetsResponseEntity = new HttpEntity<>(headers);
    }

    public List<Tweet> search(String query) {
        final String uri = BASE_QUERY_RECENT_TWEETS + query;
        final ResponseEntity<RecentSearchResponse> response = rt.exchange(uri, HttpMethod.GET, recentTweetsResponseEntity, RecentSearchResponse.class);

        List<Tweet> result = new ArrayList<>();
        if (response.getBody() != null && response.getBody().getData() != null) {
            System.out.println("response.getBody(): " + response.getBody());

            result = recentTweetsConverter.toTweets(response.getBody().getData());
        }

        logger.info("Found {} tweets matching search {}", result.size(), query);
        return result;
    }
}
