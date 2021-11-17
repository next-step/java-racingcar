package com.kkambi.racing.domain;

import java.util.Objects;

public class Location implements Comparable<Location> {

    private final int value;

    public Location(final int value) {
        if (value < 0) {
            throw new IllegalArgumentException(Error.INVALID_ARGUMENT.getMessage());
        }
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public Location move() {
        return new Location(value + 1);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return value == location.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public int compareTo(Location o) {
        return value - o.getValue();
    }
}
