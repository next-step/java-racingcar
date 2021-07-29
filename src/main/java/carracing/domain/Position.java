package carracing.domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Position implements Renderer {

    private static final String OUT_OF_RANGE_EXCEPTION_MESSAGE_FORMAT = "유효하지 않은 위치 값입니다. value: %d";
    private static final String POSITION_RENDER_DELIMITER = "";
    private static final String POSITION_EXPRESSION = "-";
    private static final int ADDITION_VALUE = 1;
    private static final int LOWER_LIMIT = 0;

    private static final Map<Integer, Position> cache = new HashMap<>();

    private final int value;

    private Position(int value) {
        this.value = value;
        cache.put(value, this);
    }

    public static Position of(int value) {
        validateLowerLimit(value);
        return cache.containsKey(value) ? cache.get(value) : new Position(value);
    }

    private static void validateLowerLimit(int value) {
        if (value < LOWER_LIMIT) {
            throw new IllegalArgumentException(String.format(OUT_OF_RANGE_EXCEPTION_MESSAGE_FORMAT, value));
        }
    }

    public Position next() {
        return Position.of(value + ADDITION_VALUE);
    }

    public boolean isAt(int value) {
        return this.value == value;
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
    public String render() {
        return String.join(POSITION_RENDER_DELIMITER, Collections.nCopies(value, POSITION_EXPRESSION));
    }
}
