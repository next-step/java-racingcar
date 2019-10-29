package step2;

import java.util.function.Function;

public class Location {
    public static final Location ZERO = new Location(0);

    private final int distance;

    private Location(final int distance) {
        this.distance = distance;
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
