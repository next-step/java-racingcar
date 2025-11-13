package racingcar.domain;

public record CarDistance(int value) {
    private static final int DEFAULT_DISTANCE = 0;
    private static final int MOVE_DISTANCE = 1;

    public CarDistance() {
        this(DEFAULT_DISTANCE);
    }

    public int getValue() {
        return this.value;
    }

    public CarDistance increase() {
        return new CarDistance(this.value + MOVE_DISTANCE);
    }
}
