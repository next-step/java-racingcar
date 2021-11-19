package racingcargamefinal.domain;

public class Position implements Comparable<Position> {

    public static final Position ZERO = new Position(0);
    private static final int MIN_VALUE = 0;

    private final int value;

    public Position() {
        this(0);
    }

    public Position(int position) {
        validate(position);
        this.value = position;
    }

    private void validate(int position) {
        if (position < MIN_VALUE) {
            throw new IllegalArgumentException("위치는 음수일 수 없습니다.");
        }
    }

    public Position move() {
        return new Position(value + 1);
    }

    public int getValue() {
        return value;
    }

    @Override
    public int compareTo(Position other) {
        return Integer.compare(this.value, other.value);
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;

        Position position = (Position) other;

        return value == position.value;
    }

    @Override
    public int hashCode() {
        return value;
    }

}
