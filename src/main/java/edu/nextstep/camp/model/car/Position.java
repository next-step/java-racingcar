package edu.nextstep.camp.model.car;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class Position implements Comparable<Position> {
    private static final int INITIAL_POSITION = 0;

    private final AtomicInteger position;

    private Position(int position) {
        this.position = new AtomicInteger(position);
    }

    public static Position ofZero() {
        return new Position(INITIAL_POSITION);
    }

    public static Position of(int position) {
        if (position < INITIAL_POSITION) {
            throw new IllegalArgumentException("invalid position: " + position);
        }

        return new Position(position);
    }

    public void forward() {
        this.position.incrementAndGet();
    }

    public int toInt() {
        return position.get();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position1 = (Position) o;
        return position.get() == position1.position.get();
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }

    @Override
    public int compareTo(Position o) {
        return position.get() - o.position.get();
    }
}
