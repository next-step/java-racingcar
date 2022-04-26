package study.step4.domain;

public class CarPosition {
    private static final int CAR_START_POSITION = 0;
    private static final int MIN_POSITION = 0;
    private static final String NOT_POSITIVE_CAR_NAME = "car postion 은 음수가될수 없다";
    private final int position;

    public CarPosition(int position) {
        if (position < MIN_POSITION) {
            throw new IllegalArgumentException(NOT_POSITIVE_CAR_NAME);
        }
        this.position = position;
    }

    public static CarPosition createDefault() {
        return new CarPosition(CAR_START_POSITION);
    }

    public CarPosition forward() {
        return new CarPosition(position + 1);
    }

    public int getPosition() {
        return position;
    }

}
