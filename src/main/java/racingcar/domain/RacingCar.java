package racingcar.domain;

import racingcar.util.RandomNumberGenerator;

public class RacingCar {
    private static final int MIN_MOVE_COUNT = 4;
    private int position;

    private RacingCar() {
        this.position = 0;
    }

    public int getPosition() {
        return position;
    }

    public void moveForward() {
        int moveCount = RandomNumberGenerator.generateRandomNumber();
        if (moveCount >= MIN_MOVE_COUNT) {
            this.position++;
        }
    }
}
