package racingcarwinnerrefactor.domain;

import racingcarwinnerrefactor.util.Strategy;

import java.util.Objects;

public class Position {
    private int position;
    private StringBuilder stringPosition = new StringBuilder();
    public static final String GO = "-";
    public static final int ADD = 1;

    public Position() {
        this(0);
    }

    public Position(int position) {
        this.position = position;
    }

    public void moveForward() {
        this.position += ADD;
        stringPosition.append(GO);
    }

    public boolean isBiggerThan(Position maxPosition) {
        return this.position >= maxPosition.position;
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

    public void move(Strategy moveStrategy) {
        if(moveStrategy.isMovable())    this.moveForward();
    }

    @Override
    public String toString() {
        return stringPosition.toString();
    }
}
