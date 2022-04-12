package me.devyonghee.racingcar.model;

import me.devyonghee.racingcar.utility.Assert;

public final class Name {

    private static final int MAX_LENGTH = 5;

    private final String value;

    private Name(String value) {
        validate(value);
        this.value = value;
    }

    public static Name from(String value) {
        return new Name(value);
    }

    private void validate(String value) {
        Assert.hasText(value, "name must be provided");
        if (value.length() > MAX_LENGTH) {
            throw new IllegalArgumentException(String.format("Name(%s) must be %d characters or less", value, MAX_LENGTH));
        }
    }
}
