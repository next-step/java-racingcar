package domain;

import java.util.Objects;

public class Position implements Comparable<Position> {
    private static final String WRONG_POSITION_MESSAGE = "위치는 0이상의 정수여야 합니다.";
    private static final int MIN_POSITION = 0;
    private int position;

    public Position() {
        this(0);
    }

    public Position(int position) {
        validatePosition(position);
        this.position = position;
    }

    private void validatePosition(int position) {
        if (position < MIN_POSITION) {
            throw new IllegalArgumentException(WRONG_POSITION_MESSAGE);
        }
    }

    public void goForward() {
        position++;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Position otherPosition = (Position) o;
        return position == otherPosition.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }

    @Override
    public int compareTo(Position o) {
        return position - o.position;
    }
}
