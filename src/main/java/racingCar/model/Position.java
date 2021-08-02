package racingCar.model;

import java.util.Objects;

public class Position {
    private static final int INITIAL_POSITION = 0;
    private static final String POSITION_ERROR_MSG = "위치는 음수 값을 가질 수 없습니다.";

    private int position;

    public Position() {
        this(INITIAL_POSITION);
    }

    public Position(int position) {
        if (position < INITIAL_POSITION) {
            throw new IllegalArgumentException(POSITION_ERROR_MSG);
        }
        this.position = position;
    }

    public Position move() {
        return new Position(position + 1);
    }

    public boolean lessThan(int position) {
        return position > this.position;
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

    public int getPosition() {
        return position;
    }

}
