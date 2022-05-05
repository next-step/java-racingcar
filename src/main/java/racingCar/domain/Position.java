package racingCar.domain;

import java.util.Objects;

public class Position {
    public static final int INITIAL_VALUE = 1;
    public static final int POSITION_MINIMUM = 0;

    private int position;

    public Position() {
        this.position = INITIAL_VALUE;
    }

    public Position(int position) {
        if (position < POSITION_MINIMUM) {
            throw new IllegalArgumentException("position 값은 0 미만이 될 수 없습니다.");
        }
        this.position = position;
    }

    public String makePosition() {
        String temporaryString = "";
        for (int i = 0; i < this.position; i++) {
            temporaryString += "-";
        }
        return temporaryString;
    }


    public Position move() {
        position++;
        return this;
    }

    public boolean isSamePosition(Position position) {
        return this.equals(position);
    }

    public boolean isBigCurrentPosition(Position maxPosition) {
        return (maxPosition.position < this.position);
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
