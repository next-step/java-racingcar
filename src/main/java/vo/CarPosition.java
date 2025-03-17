package vo;

public class CarPosition {

    private int value;

    private static final int ONE_STEP = 1;

    public CarPosition(int value) {
        this.value = value;
    }

    public static CarPosition initialize() {
        return new CarPosition(ONE_STEP);
    }

    public int getValue() {
        return value;
    }

    public void move() {
        this.value += ONE_STEP;
    }
}

