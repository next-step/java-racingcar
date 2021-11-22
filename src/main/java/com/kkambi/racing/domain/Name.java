package com.kkambi.racing.domain;

public class Name {

    private final String value;

    public Name(final String value) {
        if (value.length() > 5) {
            throw new IllegalArgumentException(Error.INVALID_ARGUMENT.getMessage());
        }
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
