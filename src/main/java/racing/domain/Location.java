package racing.domain;

import java.util.Objects;

public class Location implements Comparable<Location> {
    private static final int DEFAULT_LOCATION = 0;
    private final int number;

    public Location(final int number) {
        if (number < DEFAULT_LOCATION) {
            throw new IllegalArgumentException("위치는 0이상이어야 합니다.");
        }
        this.number = number;
    }

    public static Location defaultLocation() {
        return new Location(DEFAULT_LOCATION);
    }

    public Location forward() {
        return new Location(this.number + 1);
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

    @Override
    public int compareTo(final Location o) {
        return Integer.compare(this.number, o.number);
    }
}
