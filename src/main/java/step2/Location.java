package step2;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.function.Function;

public class Location {
    public static final Location ZERO = new Location(0);

    private final int distance;

    private Location(final int distance) {
        this.distance = distance;
    }

    public static Location of(final int distance) {
        return new Location(distance);
    }

    public Location goForward() {
        return goForward(1, Unit.STEP);
    }

    public Location goForward(final int value, final Unit unit) {
        return new Location(distance + unit.convert(value));
    }

    public int current() {
        return distance;
    }

    @Override
    public String toString() {
        return String.valueOf(distance);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof Location)) return false;
        final Location location = (Location) o;
        return distance == location.distance;
    }

    @Override
    public int hashCode() {
        return Objects.hash(distance);
    }

    enum Unit {
        STEP(value -> value);

        private final Function<Integer, Integer> converter;

        Unit(final Function<Integer, Integer> converter) {
            this.converter = converter;
        }

        public int convert(final int value) {
            return converter.apply(value);
        }
    }
}
