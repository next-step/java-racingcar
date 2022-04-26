package racingcar.domain;

import java.util.Objects;

public class Position {

    private int movement;

    public Position() {
        this(0);
    }

    public Position(int movement) {
        if (movement < 0) {
            throw new IllegalArgumentException("position은 음수 값을 가질 수 없습니다.");
        }
        this.movement = movement;
    }

    public void move() {
        movement = movement + 1;
    }

    public int getMovement() {
        return movement;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position1 = (Position) o;
        return movement == position1.movement;
    }

    @Override
    public int hashCode() {
        return Objects.hash(movement);
    }
}
