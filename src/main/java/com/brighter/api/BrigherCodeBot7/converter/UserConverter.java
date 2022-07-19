package com.brighter.api.BrigherCodeBot7.converter;

import com.brighter.api.BrigherCodeBot7.domain.User;
import com.brighter.api.BrigherCodeBot7.domain.http.userlookup.UserLookupData;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {
    public User toUsers(UserLookupData data) {
        return new User(
                data.getId(),
                data.getName(),
                data.getUsername(),
                data.getLocation() == null ? "" : data.getLocation()
        );
    }
}
