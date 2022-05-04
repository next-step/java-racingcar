package racingCar.domain;

import java.util.Objects;

public class Position {
    public static final int INITIAL_VALUE = 1;

    private int position;

    public Position() {
        this.position = INITIAL_VALUE;
    }

    public Position(int position) {
        this.position = position;
    }

    public String makePosition() {
        String temporaryString = "";
        for (int i = 0; i < this.position; i++) {
            temporaryString += "-";
        }
        return temporaryString;
    }

    public int getPosition() {
        return position;
    }

    public Position move() {
        position++;
        return this;
    }

    public Position move2() {
        return new Position(position + 1);
    }

    public void move3() {
        position++;
    }

    public boolean isSamePosition(int position) {
        return this.position == position;
    }

    public boolean isBigPosition(int maxPosition) {
        return (maxPosition < this.position);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position1 = (Position) o;
        return getPosition() == position1.getPosition();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPosition());
    }
}
