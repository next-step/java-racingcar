package racingcar;

public class CarPosition {

    public static int DEFAULT_POSITION = 0;
    private int position;

    private CarPosition(int position) {
        validate(position);
        this.position = position;
    }

    public static CarPosition newInstance() {
        return of(DEFAULT_POSITION);
    }

    public static CarPosition of(int position) {
        return new CarPosition(position);
    }

    public int getPosition() {
        return position;
    }

    private void validate(int position) {
        if (position < DEFAULT_POSITION) {
            throw new IllegalArgumentException();
        }
    }
}
