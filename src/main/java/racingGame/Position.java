package racingGame;

public class Position {
    private final int value;

    private Position(int value) {
        validate(value);
        this.value = value;
    }

    public static Position start() {
        return new Position(0);
    }

    public Position move() {
        return new Position(value + 1);
    }

    public int value() {
        return value;
    }

    public boolean isSame(int target) {
        return value == target;
    }

    public boolean isGreaterThan(int other) {
        return value > other;
    }

    private void validate(int value) {
        if (value < 0) {
            throw new IllegalArgumentException("위치는 음수일 수 없습니다. value = " + value);
        }
    }
}
