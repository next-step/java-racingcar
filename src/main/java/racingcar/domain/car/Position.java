package racingcar.domain.car;

import java.util.Objects;

public class Position implements Comparable<Position> {

    private static final int MIN_POSITION = 0;
    private static final String INVALID_POSITION_MESSAGE = "이동거리는 음수가 될수 없습니다.";

    private int value;

    public Position() {
        this(MIN_POSITION);
    }

    public Position(String value) {
        this(Integer.parseInt(value));
    }

    public Position(int value) {
        if (value < MIN_POSITION) {
            throw new IllegalArgumentException(INVALID_POSITION_MESSAGE);
        }
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    public void plus() {
        this.value = this.value + 1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Position position1 = (Position) o;
        return value == position1.value;
    }


    @Override
    public int hashCode() {
        return Objects.hash(value);
    }


    @Override
    public String toString() {
        return "Position{" +
                "position=" + value +
                '}';
    }

    @Override
    public int compareTo(Position position) {
        return Integer.compare(this.value, position.getValue());
    }
}
