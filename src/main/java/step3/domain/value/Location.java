package step3.domain.value;

import java.util.Objects;

public class Location {
    private final int value;

    public Location(int value) {
        this.value = value;
    }

    public Location forward() {
        return new Location(value + 1);
    }

    public int getValue() {
        return value;
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
}
