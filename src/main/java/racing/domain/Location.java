package racing.domain;

import java.util.Objects;

public class Location {
    private static final int DEFAULT_LOCATION = 0;
    private final int number;

    private Location(final int number) {
        if (number < 0) {
            throw new IllegalArgumentException("음수가 될 수 없습니다.");
        }
        this.number = number;
    }

    public static Location of() {
        return new Location(DEFAULT_LOCATION);
    }

    public static Location of(final int number) {
        return new Location(number);
    }

    public Location forward() {
        return Location.of(this.number + 1);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {return true;}
        if (o == null || getClass() != o.getClass()) {return false;}
        final Location location = (Location) o;
        return number == location.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public String toString() {
        return "Location{" +
               "number=" + number +
               '}';
    }
}
