package com.nextstep.racinggame.domain;

import java.util.Objects;

public class Fuel {
    private final int value;

    public Fuel(final int value) {
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
