package com.brighter.api.BrigherCodeBot7.randomstring.dto;

public class GeneratorDto {
    private String value;
    private String type;
    private int minlength;
    private int maxlength;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getMinlength() {
        return minlength;
    }

    public void setMinlength(int minlength) {
        this.minlength = minlength;
    }

    public int getMaxlength() {
        return maxlength;
    }

    public void setMaxlength(int maxlength) {
        this.maxlength = maxlength;
    }
}
