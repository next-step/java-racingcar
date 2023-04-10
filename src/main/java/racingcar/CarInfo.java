package racingcar;

import lombok.Data;

@Data
public class CarInfo {
    private int prevDistance = 0;
    private int currentDistance = 0;
    private int resultOfRand;

    public void moveFoward() {
        prevDistance = currentDistance;
        currentDistance = prevDistance + 1;
    }

    public boolean isMoved() {
        return currentDistance - prevDistance > 0;
    }

    public boolean isRandGreaterThan4() {
        return resultOfRand > 4;
    }
}
