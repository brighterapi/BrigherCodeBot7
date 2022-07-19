package com.brighter.api.BrigherCodeBot7.domain.http.recentsearch;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RecentSearchMeta {
    @JsonProperty("newest_id")
    long newestId;
    @JsonProperty("oldest_id")
    long oldestId;
    @JsonProperty("result_count")
    long resultCount;

    public RecentSearchMeta(long newestId, long oldestId, long resultCount) {
        this.newestId = newestId;
        this.oldestId = oldestId;
        this.resultCount = resultCount;
    }

    public long getNewestId() {
        return newestId;
    }

    public void setNewestId(long newestId) {
        this.newestId = newestId;
    }

    public long getOldestId() {
        return oldestId;
    }

    public void setOldestId(long oldestId) {
        this.oldestId = oldestId;
    }

    public long getResultCount() {
        return resultCount;
    }

    public void setResultCount(long resultCount) {
        this.resultCount = resultCount;
    }
}
