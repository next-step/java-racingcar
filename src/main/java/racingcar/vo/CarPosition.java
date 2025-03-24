package racingcar.vo;

public class CarPosition {

    private static final int ONE_STEP = 1;

    private final int value;

    public CarPosition(int value) {
        this.value = value;
    }

    public static CarPosition initialize() {
        return new CarPosition(ONE_STEP);
    }

    public CarPosition move() {
        return new CarPosition(this.value + ONE_STEP);
    }

    public int getValue() {
        return value;
    }
}

