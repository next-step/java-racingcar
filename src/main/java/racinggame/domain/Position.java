package racinggame.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Position {
    private static final Map<Integer, Position> positions = new HashMap<>();

    static {
        for (int i = 0; i < 100; i++) {
            positions.put(i, new Position(i));
        }
    }

    private final int position;

    private Position(int position) {
        this.position = position;
    }

    public static Position of(int number) {
        Position position = positions.get(number);
        if (position == null) {
            return new Position(number);
        }
        return position;
    }

    public Position movedPosition() {
        return new Position(this.position + 1);
    }

    public boolean isBiggerThan(Position maxPosition) {
        return this.position > maxPosition.position;
    }

    public int position() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position1 = (Position) o;
        return position == position1.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}
