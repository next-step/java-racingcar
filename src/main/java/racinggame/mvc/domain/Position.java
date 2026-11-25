package racinggame.mvc.domain;

public final class Position {

    private static final int MIN_POSITION = 0;

    private int value;

    public Position(int value) {
        validatePosition(value);
        this.value = value;
    }

    private void validatePosition(int value) {
        if (value < MIN_POSITION) {
            throw new IllegalArgumentException("자동차 위치는 음수일 수 없습니다.");
        }
    }

    public void advance() {
        value = Math.incrementExact(value);
    }

    public int compareWith(Position other) {
        return Integer.compare(value, other.value);
    }

    public int getValue() {
        return value;
    }
}
