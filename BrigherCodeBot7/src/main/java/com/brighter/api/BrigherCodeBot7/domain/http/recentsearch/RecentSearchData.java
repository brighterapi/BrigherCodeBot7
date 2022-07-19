package com.brighter.api.BrigherCodeBot7.domain.http.recentsearch;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RecentSearchData {
    @JsonProperty("id")
    long id;
    @JsonProperty("author_id")
    long authorId;
    @JsonProperty("lang")
    String lang;
    @JsonProperty("text")
    String text;

    public RecentSearchData(long id, long authorId, String lang, String text) {
        this.id = id;
        this.authorId = authorId;
        this.lang = lang;
        this.text = text;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(long authorId) {
        this.authorId = authorId;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
