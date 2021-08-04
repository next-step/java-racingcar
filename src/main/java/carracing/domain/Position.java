package carracing.domain;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Position implements Comparable<Position> {

    private static final String OUT_OF_RANGE_EXCEPTION_MESSAGE_FORMAT = "유효하지 않은 위치 값입니다. value: %d";
    private static final int ADDITION_VALUE = 1;
    private static final int LOWER_LIMIT = 0;

    private static final Map<Integer, Position> cache = new ConcurrentHashMap<>();

    private final int value;

    private Position(int value) {
        this.value = value;
    }

    public static Position of(int value) {
        validateLowerLimit(value);
        cacheIfAbsent(value);
        return cache.get(value);
    }

    private static void validateLowerLimit(int value) {
        if (value < LOWER_LIMIT) {
            throw new IllegalArgumentException(String.format(OUT_OF_RANGE_EXCEPTION_MESSAGE_FORMAT, value));
        }
    }

    private static void cacheIfAbsent(int value) {
        if (!cache.containsKey(value)) {
            cache.putIfAbsent(value, new Position(value));
        }
    }

    public Position next() {
        return Position.of(value + ADDITION_VALUE);
    }

    public boolean isAt(int value) {
        return this.value == value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Position)) return false;
        Position other = (Position) o;
        return this.value == other.value;
    }

    @Override
    public int hashCode() {
        return value;
    }

    @Override
    public int compareTo(Position other) {
        return Integer.compare(this.value, other.value);
    }
}
