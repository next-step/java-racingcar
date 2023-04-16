package racingcar.domain;

import java.util.Random;

public class Car {
    public static final int MOVEABLE_POWER = 4;
    private int moveCount = 0;

    public void moveForwardOrStop(int inputPower) {
        if (inputPower >= MOVEABLE_POWER) {
            moveCount++;
        }
    }

    public int getMoveCount() {
        return moveCount;
    }
}
