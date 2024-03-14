package racinggame.domain;

import java.util.Objects;

public class Position {
    private int number;

    public Position(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("0보다 작은 값이 될 수 없습니다.");
        }
        this.number = number;
    }

    public int getPosition() {
        return this.number;
    }

    public int max(int other) {
        if (this.number > other) {
            return this.number;
        }
        return other;
    }

    public boolean isMatch(int maxPosition) {
        return this.number == maxPosition;
    }

    public void increase() {
        this.number += 1;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return number == position.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
