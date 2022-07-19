package com.brighter.api.BrigherCodeBot7.twitter.api1;

import com.brighter.api.BrigherCodeBot7.cache.RetweetCache;
import com.brighter.api.BrigherCodeBot7.domain.Tweet;
import com.brighter.api.BrigherCodeBot7.twitter.TwitterApi1Endpoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import twitter4j.Twitter;
import twitter4j.TwitterException;

@Component
public class RetweetEndpoint extends TwitterApi1Endpoint {
    private static final Logger logger = LoggerFactory.getLogger(RetweetEndpoint.class);
    private final Twitter twitter;
    private final RetweetCache retweetCache;

    @Autowired
    public RetweetEndpoint(Twitter twitter, RetweetCache retweetCache, RestTemplate rt) {
        super(rt);
        this.retweetCache = retweetCache;
        this.twitter = twitter;
    }

    public void retweet(Tweet tweet) {
        final long id = tweet.getId();
        logger.info("Retweeting tweet with id {} ...", id);

        System.out.println("User ID " + tweet.getUser().getId() + "User Name :" + tweet.getUser().getName());
        try {
            twitter.retweetStatus(id);
            logger.info("Successfully retweeted tweet {}", id);
            retweetCache.add(id);
        } catch (TwitterException e) {
            if (e.getStatusCode() == 403 && e.getErrorCode() == 327) {
                logger.warn("Tweet {} has already been retweeted. Skipping and adding to cache.", id);
          //      retweetCache.add(id);
            } else {
                logger.error("Error trying to retweet tweet {}", id, e);
            }
        }
    }
}
