package com.next.step.step3.domain.vo;

import java.util.Objects;

public class Position {

    private static final int MOVE_PER_ONCE = 1;

    private final int position;

    public Position(int position) {
        this.position = position;
    }

    public Position movePosition() {
        return new Position(this.position + MOVE_PER_ONCE);
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
