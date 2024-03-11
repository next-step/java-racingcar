package model;

import java.util.Objects;

public class Location {

    private int value;

    public Location(final int value) {
        this.value = value;
    }

    public void increase() {
        value++;
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final Location location = (Location) o;
        return getValue() == location.getValue();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getValue());
    }

    @Override
    public String toString() {
        return "Location{" +
                "value=" + value +
                '}';
    }
}
