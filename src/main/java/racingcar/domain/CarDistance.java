package racingcar.domain;

public class CarDistance {
    private static final int DEFAULT_DISTANCE = 0;

    private int value;

    public CarDistance() {
        this.value = DEFAULT_DISTANCE;
    }

    public int getValue() {
        return this.value;
    }
}
