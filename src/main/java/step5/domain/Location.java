package step5.domain;

import java.util.Objects;

public class Location {
    private final int value;

    public Location(int value) {
        this.value = value;
    }

    public Location add(int offset) {
        return new Location(this.value + offset);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return value == location.value;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }

    public Location max(Location other) {
        if (this.value >= other.value) {
            return this;
        }
        return other;
    }

    public int getValue() {
        return this.value;
    }
}
