package racingcar;

import lombok.Data;

@Data
public class Car {
    private int prevDistance = 0;
    private int currentDistance = 0;
    private int resultOfRand;

    public void moveFoward() {
        prevDistance = currentDistance;
        currentDistance = prevDistance + 1;
    }

    public boolean isMoved(int diff) {
        return diff > 0;
    }

    public int diffBetweenCurrentDistAndPrevDist() {
        return currentDistance - prevDistance;
    }

    public boolean isRandGreaterThan(int threshold) {
        return resultOfRand > threshold;
    }
}
