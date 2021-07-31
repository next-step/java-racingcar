package step3.car;

public class Car {

    private static final int STAY_THRESHOLD = 3;
    private static final int VALUE_LOWER_BOUND = 0;
    private static final int VALUE_UPPER_BOUND = 10;

    private int movedDistance = 0;

    public void tryMove(int value) {
        validateValue(value);

        if (isMoveCondition(value))
            move();
    }

    private void validateValue(int value) {
        if (value < VALUE_LOWER_BOUND || value >= VALUE_UPPER_BOUND)
            throw new IllegalArgumentException();
    }

    private boolean isMoveCondition(int value) {
        return value > STAY_THRESHOLD;
    }

    private void move() {
        movedDistance++;
    }

    public Position getCurrentPosition() {
        return new Position(movedDistance);
    }
}
