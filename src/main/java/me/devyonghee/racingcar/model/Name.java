package me.devyonghee.racingcar.model;

import me.devyonghee.racingcar.utility.Assert;

import java.util.Objects;

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

    public String value() {
        return value;
    }

    private void validate(String value) {
        Assert.hasText(value, "name must be provided");
        if (value.length() > MAX_LENGTH) {
            throw new IllegalArgumentException(String.format("name(%s) must be %d characters or less", value, MAX_LENGTH));
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Name name = (Name) o;
        return Objects.equals(value, name.value);
    }
}
