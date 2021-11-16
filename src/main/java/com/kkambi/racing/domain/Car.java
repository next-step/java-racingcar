package com.kkambi.racing.domain;

import java.util.Objects;

public class Car {

    private static final int criteriaToMove = 4;

    private Location location;
    private final Name name;

    public Car(final int location, final String name) {
        this.location = new Location(location);
        this.name = new Name(name);
    }

    public void tryToMove(int randomValue) {
        if (randomValue >= criteriaToMove) {
            this.location = location.move();
        }
    }

    public Location getLocation() {
        return location;
    }

    public Name getName() {
        return name;
    }

    public static class Location implements Comparable<Location> {
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

    public static class Name {
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
}
