package step3.car;

public class Car {

    private static final int STAY_THRESHOLD = 3;

    private int movedDistance = 0;

    public void tryMove(int randomValue) {
        validateRandomValue(randomValue);

        if (isMoveCondition(randomValue))
            move();
    }

    private void validateRandomValue(int randomValue) {
        if (randomValue < 0 || randomValue > 9)
            throw new IllegalArgumentException();
    }

    private boolean isMoveCondition(int value) {
        return value > STAY_THRESHOLD;
    }

    private void move() {
        movedDistance++;
    }

    public int getMovedDistance() {
        return movedDistance;
    }
}
