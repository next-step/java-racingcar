package racingcargamefinal.domain;

public class Position {

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

    public Position findBigger(Position other) {
        return this.value > other.value ? this : other;
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object ohter) {
        if (this == ohter) return true;
        if (ohter == null || getClass() != ohter.getClass()) return false;

        Position position = (Position) ohter;

        return value == position.value;
    }

    @Override
    public int hashCode() {
        return value;
    }

}
