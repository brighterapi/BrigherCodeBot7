package com.brighter.api.BrigherCodeBot7.converter;

import com.brighter.api.BrigherCodeBot7.cache.UserCache;
import com.brighter.api.BrigherCodeBot7.domain.Tweet;
import com.brighter.api.BrigherCodeBot7.domain.http.recentsearch.RecentSearchData;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class RecentTweetsConverter {

    private final UserCache userCache;

    public RecentTweetsConverter(UserCache userCache) {
        this.userCache = userCache;
    }

    public List<Tweet> toTweets(List<RecentSearchData> data) {
        return data.stream().map(d -> new Tweet(d.getId(), d.getLang(), d.getText(), userCache.getById(d.getAuthorId()))).collect(Collectors.toList());
    }
}
