package racingCar;

import racingCar.utils.NumberUtils;

public class Car {
    int moveCount = 0;

    private static final int COMPARE_VALUE = 4;

    public String printRace() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < moveCount; i++) {
            sb.append('-');
        }

        return sb.toString();
    }

    public void move() {
        if (NumberUtils.getRandomNumber() >= COMPARE_VALUE) {
            moveCount += 1;
        }
    }
}
