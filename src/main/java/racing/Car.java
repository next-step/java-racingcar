package racing;

public class Car {
    public static final int UPPER_BOUND = 9;
    public static final int LOWER_BOUND = 0;
    private static final int MOVEMENT_THRESHOLD = 4;
    private int position = 0;

    public int getPosition() {
        return position;
    }

    public void goForward(int value) {
        checkValidity(value);
        if (canMove(value)) {
            position++;
        }
    }

    private void checkValidity(int value) {
        if (value < LOWER_BOUND || UPPER_BOUND < value) {
            throw new IllegalArgumentException("[0, 9] 값만 가능합니다.");
        }
    }

    private boolean canMove(int value) {
        return value >= MOVEMENT_THRESHOLD;
    }
}
