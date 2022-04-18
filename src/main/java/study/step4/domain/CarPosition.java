package study.step4.domain;

public class CarPosition {
    private static final int CAR_START_POSITION = 0;
    private final int position;

    public CarPosition(int position) {
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
