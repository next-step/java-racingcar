package edu.nextstep.camp.carracing.domain;

import java.util.Objects;

public class Position {
    private final int value;

    public Position() {
        this(0);
    }

    public Position(int value) {
        if (value < 0) {
            throw new IllegalArgumentException("위치 값에 음수가 들어갈 수 없습니다.");
        }
        this.value = value;
    }

    public Position increment() {
        return new Position(this.value + 1);
    }

    public boolean isSame(int number) {
        return this.value == number;
    }

    public int max(int number) {
        return Math.max(this.value, number);
    }

    public int getValue() {
        return this.value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Position)) {
            return false;
        }
        Position other = (Position) o;
        return this.value == other.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
