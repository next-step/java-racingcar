package racingcar.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Position implements Comparable<Position> {
    private static final Map<Integer, Position> CACHE = new HashMap<>();
    private int value;

    private Position(int value) {
        this.value = value;
    }

    public static Position valueOf(int value) {
        if (!CACHE.containsKey(value)) {
            Position position = new Position(value);
            CACHE.put(value, position);
        }
        return CACHE.get(value);
    }

    public static Position add(Position operand1, Position operand2) {
        return Position.valueOf(operand1.value + operand2.value);
    }

    public static int toInteger(Position position) {
        return position.value;
    }

    @Override
    public int compareTo(Position o) {
        Integer value = this.value;
        return value.compareTo(o.value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Position)) return false;
        Position position = (Position) o;
        return value == position.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
