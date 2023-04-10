package racingcar;

import lombok.Data;

@Data
public class CarInfo {
    private int prevDistance;
    private int currentDistance;
    private int resultOfRand;

    public CarInfo() {
        this.currentDistance = 0;
    }

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
