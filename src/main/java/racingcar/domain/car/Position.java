package racingcar.domain.car;

public class Position {

    private final int value;

    public Position(int value) {
        valid(value);
        this.value = value;
    }

    private void valid(int value) {
        if (value < 0) {
            throw new IllegalArgumentException("position is not available");
        }
    }

    public int getValue() {
        return value;
    }

    public boolean isEquals(int value) {
        return this.value == value;
    }
}
