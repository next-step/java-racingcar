package com.nextstep.racinggame.domain;

import com.nextstep.racinggame.domain.exceptions.InvalidFuelValueException;

import java.util.Objects;

public class Fuel {
    private static final int MIN_VALUE = 0;
    private static final int MAX_VALUE = 9;
    private static final int ENOUGH_VALUE = 4;

    private final int value;

    public Fuel(final int value) {
        validate(value);

        this.value = value;
    }

    private void validate(final int value) {
        if (value < MIN_VALUE || value > MAX_VALUE) {
            throw new InvalidFuelValueException("유효하지 않은 연료값입니다.");
        }
    }

    public boolean isEnough() {
        return this.value >= ENOUGH_VALUE;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fuel fuel = (Fuel) o;
        return value == fuel.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "Fuel{" +
                "value=" + value +
                '}';
    }
}
