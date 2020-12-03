package com.nextstep.racinggame.domain;

import com.nextstep.racinggame.domain.exceptions.InvalidFuelValueException;

import java.util.Objects;

public class Fuel {
    private final int value;

    public Fuel(final int value) {
        if (value < 0 || value > 9) {
            throw new InvalidFuelValueException("유효하지 않은 연료값입니다.");
        }

        this.value = value;
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
