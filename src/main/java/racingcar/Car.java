package racingcar;

public class Car {
    private final int prevDistance;
    private final int currentDistance;
    private final int rand;

    public Car() {
        this.prevDistance = 0;
        this.currentDistance = 0;
        this.rand = 0;
    }

    public Car(int prevDistance, int currentDistance, int rand) {
        this.prevDistance = prevDistance;
        this.currentDistance = currentDistance;
        this.rand = rand;
    }

    public Car moveFoward(int rand) {
        return new Car(currentDistance, currentDistance + 1, rand);
    }

    public boolean isMoved(int value) {
        return value > 0;
    }

    public boolean isRandGreaterThan(int threshold) {
        return rand > threshold;
    }

    public int diffBetweenCurrentDistAndPrevDist() {
        return currentDistance - prevDistance;
    }

    public int currentPosition() {
        return currentDistance;
    }
}
