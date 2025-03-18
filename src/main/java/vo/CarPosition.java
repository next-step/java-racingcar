package vo;

public class CarPosition {

    private static final int ONE_STEP = 1;

    private int value;

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

