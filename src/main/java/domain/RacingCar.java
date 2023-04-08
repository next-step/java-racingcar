package domain;

import util.RandomNumberGenerator;

public class RacingCar {
    private static final int STANDARD_MOVE_COUNT = 4;
    private int position;

    public RacingCar() {
        this.position = 0;
    }

    public int getPosition() {
        return position;
    }

    public void moveForward() {
        int moveCount = RandomNumberGenerator.generateRandomNumber();
        if (moveCount >= STANDARD_MOVE_COUNT) {
            this.position++;
        }
    }
}
