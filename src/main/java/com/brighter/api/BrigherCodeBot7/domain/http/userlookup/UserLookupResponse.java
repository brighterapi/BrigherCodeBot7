package com.brighter.api.BrigherCodeBot7.domain.http.userlookup;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserLookupResponse {
    @JsonProperty("data")
    UserLookupData data;

    public UserLookupResponse() {
    }

    public UserLookupResponse(UserLookupData data) {
        this.data = data;
    }

    public UserLookupData getData() {
        return data;
    }

    public void setData(UserLookupData data) {
        this.data = data;
    }
}
