package com.brighter.api.BrigherCodeBot7.domain.http.recentsearch;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RecentSearchResponse {
    @JsonProperty("data")
    List<RecentSearchData> data;
    @JsonProperty("meta")
    RecentSearchMeta meta;

    public RecentSearchResponse(List<RecentSearchData> data, RecentSearchMeta meta) {
        this.data = data;
        this.meta = meta;
    }

    public List<RecentSearchData> getData() {
        return data;
    }

    public void setData(List<RecentSearchData> data) {
        this.data = data;
    }

    public RecentSearchMeta getMeta() {
        return meta;
    }

    public void setMeta(RecentSearchMeta meta) {
        this.meta = meta;
    }
}
