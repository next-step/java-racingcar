package racingcar;

public class Car {
    private final String name;
    private final int prevDistance;
    private final int currentDistance;
    private final int rand;

    public Car(String name) {
        this.name = name;
        this.prevDistance = 0;
        this.currentDistance = 0;
        this.rand = 0;
    }

    public Car(String name, int prevDistance, int currentDistance, int rand) {
        this.name = name;
        this.prevDistance = prevDistance;
        this.currentDistance = currentDistance;
        this.rand = rand;
    }

    public String name() {
        return name;
    }

    public int currentDistance() {
        return currentDistance;
    }

    public Car moveFoward(int rand) {
        return new Car(name, currentDistance, currentDistance + 1, rand);
    }

    public boolean isMoved(int value) {
        return value > 0;
    }

    public boolean isRandGreaterThan(int threshold) {
        return rand > threshold;
    }

    public boolean isFurtherThan(int distance) {
        return currentDistance > distance;
    }

    public boolean isSameDistance(int distance) {
        return currentDistance == distance;
    }

    public int diffBetweenCurrentDistAndPrevDist() {
        return currentDistance - prevDistance;
    }

    public int currentPosition() {
        return currentDistance;
    }

    public String nameAppendTo(String dashes) {
        return this.name + " : " + dashes;
    }
}
