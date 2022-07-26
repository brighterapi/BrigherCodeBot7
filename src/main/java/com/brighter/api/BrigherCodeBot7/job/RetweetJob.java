package com.brighter.api.BrigherCodeBot7.job;

import com.brighter.api.BrigherCodeBot7.cache.RetweetCache;
import com.brighter.api.BrigherCodeBot7.domain.Tweet;
import com.brighter.api.BrigherCodeBot7.twitter.api1.MeEndpoint;
import com.brighter.api.BrigherCodeBot7.twitter.api1.RetweetEndpoint;
import com.brighter.api.BrigherCodeBot7.twitter.api2.RecentTweetsEndpoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import twitter4j.TwitterException;

@Component
@EnableScheduling
public class RetweetJob {
    private static final Logger logger = LoggerFactory.getLogger(RetweetJob.class);
    private static final int FETCHING_RATE = 1000 * 60 * 5;

    private final RecentTweetsEndpoint recentTweetsEndpoint;
    private final RetweetEndpoint retweetEndpoint;
    private final MeEndpoint meEndpoint;
    private final RetweetCache retweetCache;
    private final String search;

    @Autowired
    public RetweetJob(RecentTweetsEndpoint recentTweetsEndpoint, RetweetEndpoint retweetEndpoint, MeEndpoint meEndpoint, RetweetCache retweetCache, @Value("${search}") String search) {
        this.recentTweetsEndpoint = recentTweetsEndpoint;
        this.retweetEndpoint = retweetEndpoint;
        this.meEndpoint = meEndpoint;
        this.retweetCache = retweetCache;
        this.search = search;
    }

    @Scheduled(fixedRate = FETCHING_RATE)
    public void searchTweets() throws TwitterException {
        logger.info("Looking for unseen tweets for search {}", search);
        final long myId = meEndpoint.getId();

        recentTweetsEndpoint.search(search).stream().filter(tweet -> shouldRetweet(tweet, myId)).peek(tweet -> logger.info("Found Tweet: ID \"{}\", Author \"{}\", Language \"{}\", Location \"{}\", Text \"{}\".", tweet.getId(), tweet.getUser().getName(), tweet.getLang(), tweet.getUser().getLocation(), tweet.getText())).forEach(retweetEndpoint::retweet);


    }

    private boolean shouldRetweet(Tweet tweet, long myId) {
        return !isTweetFromMe(tweet, myId) && !isRetweet(tweet) && !hasBeenSeen(tweet);
    }

    private boolean isTweetFromMe(Tweet tweet, long myId) {
        return tweet.getUser().getId() == myId;
    }

    private boolean isRetweet(Tweet tweet) {
        return tweet.getText().startsWith("RT @");
    }

    private boolean hasBeenSeen(Tweet tweet) {
        return retweetCache.contains(tweet.getId());
    }
}
