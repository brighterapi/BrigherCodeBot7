package com.brighter.api.BrigherCodeBot7.randomstring;

public enum RandomStringGeneratorEnum {
    numeric("numeric"),
    alphabetic("alphabetic"),
    alphanumeric("alphanumeric"),
    alphanumericspecial("alphanumericspecial");

    private String value;

    public String getValue() {
        return value;
    }

    RandomStringGeneratorEnum(String value) {
        this.value = value;
    }
}
