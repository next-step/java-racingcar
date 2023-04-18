package racing.domain;

import java.util.Objects;

public class Position implements Comparable<Position> {
    private static final int START_POSITION = 0;
    private final int position;

    public Position() {
        this(START_POSITION);
    }

    public Position(int position) {
        if (isUnderStartPosition(position)) {
            throw new IllegalArgumentException("자동차의 위치는 " + START_POSITION + " 이상이어야 합니다.");
        }
        this.position = position;
    }

    private static boolean isUnderStartPosition(int position) {
        return position < START_POSITION;
    }

    public int getPosition() {
        return position;
    }

    public Position increase(int number) {
        return new Position(position + number);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position1 = (Position) o;
        return Objects.equals(position, position1.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }

    @Override
    public int compareTo(Position o) {
        return Integer.compare(position, o.position);
    }
}