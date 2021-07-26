package racing.domain.car.vo;

import java.util.Comparator;

public class Location extends Number implements Comparable<Location> {
    private static final String UNDER_LOCATION_MESSAGE = "연료는 음수르 충전할 수 없습니다.";

    private static final int MIN_VALUE = 0;
    private static final int ONE_BLOCK_VALUE = 1;

    private final int value;

    public Location(int location) {
        validate(location);
        this.value = location;
    }

    public static Location empty() {
        return InnerInstanceClazz.EMPTY;
    }

    public static Location oneBlock() {
        return InnerInstanceClazz.ONE_BLOCK;
    }

    private static void validate(int value) {
        if (value < MIN_VALUE)
            throw new IllegalArgumentException(UNDER_LOCATION_MESSAGE);
    }

    public Location add(Location location) {
        return new Location(
                this.value + location.value
        );
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(value);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Location) {
            Location compareLocation = (Location) obj;
            return this.value == compareLocation.value;
        }
        return false;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    @Override
    public int compareTo(Location compareLocation) {
        return Integer.compare(this.value, compareLocation.value);
    }

    @Override
    public int intValue() {
        return value;
    }

    @Override
    public long longValue() {
        return value;
    }

    @Override
    public float floatValue() {
        return (float) value;
    }

    @Override
    public double doubleValue() {
        return value;
    }

    private static class InnerInstanceClazz {
        private static final Location EMPTY = new Location(MIN_VALUE);
        private static final Location ONE_BLOCK = new Location(ONE_BLOCK_VALUE);
    }
}
