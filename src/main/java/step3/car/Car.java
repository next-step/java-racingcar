package step3.car;

public class Car {

    private static final int STAY_THRESHOLD = 3;
    private static final int VALUE_LOWER_BOUND = 0;
    private static final int VALUE_UPPER_BOUND = 10;

    private int movedDistance = 0;

    public void tryMove(int randomValue) {
        validateRandomValue(randomValue);

        if (isMoveCondition(randomValue))
            move();
    }

    private void validateRandomValue(int randomValue) {
        if (randomValue < VALUE_LOWER_BOUND || randomValue >= VALUE_UPPER_BOUND)
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
