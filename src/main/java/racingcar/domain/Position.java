package racingcar.domain;

import java.util.Objects;

public class Position implements Comparable<Position> {

    private static final int DEFAULT_POSITION = 0;
    private final int steps;

    public Position() {
        this(DEFAULT_POSITION);
    }

    public Position(int steps) {
        if (steps < DEFAULT_POSITION) {
            throw new IllegalArgumentException("position must be at least 0");
        }
        this.steps = steps;
    }

    public Position move() {
        return new Position(steps + 1);
    }

    public int getSteps() {
        return steps;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position1 = (Position) o;
        return steps == position1.steps;
    }

    @Override
    public int hashCode() {
        return Objects.hash(steps);
    }

    @Override
    public int compareTo(Position p) {
        return Integer.compare(steps, p.steps);
    }
}
