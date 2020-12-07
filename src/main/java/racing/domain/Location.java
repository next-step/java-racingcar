package racing.domain;

import racing.exception.LocationOutOfRangeException;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Location {

    public static final int MIN_VALUE = 0;
    private static final int MOVE_DISTANCE = 1;

    private static final Map<Integer, Location> CACHE = new HashMap<>();

    private final int value;

    private Location(final int value) {
        this.value = value;
    }

    public static Location valueOf(final int value) {
        if (value < MIN_VALUE) {
            throw new LocationOutOfRangeException(value);
        }
        return CACHE.computeIfAbsent(value, Location::new);
    }

    public Location forward() {
        return valueOf(value + MOVE_DISTANCE);
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof Location)) return false;
        final Location location = (Location) o;
        return value == location.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
