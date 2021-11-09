package racingCar;

import racingCar.utils.NumberUtils;

public class Car {
    private static final int COMPARE_VALUE = 4;

    private int moveCount = 0;

    public void move() {
        if (NumberUtils.getRandomNumber() >= COMPARE_VALUE) {
            moveCount += 1;
        }
    }

    public int getMoveCount() {
        return moveCount;
    }
}
