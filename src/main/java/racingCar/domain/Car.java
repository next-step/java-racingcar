package racingCar.domain;

import java.util.Random;

public class Car {
    private static final int CAR_STEP_LIMIT = 4;
    private final String name;
    private int position = 0;
    private Random random = new Random();
    private boolean winnerFlag = false;

    public Car (final String name) {
        this.name = name;
    }

    public void step(final int number) {
        if (number >= CAR_STEP_LIMIT)
            this.position++;
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }

    public void winnerCheck(int maxPosition) {
        winnerFlag = false;
        if (this.position >= maxPosition) {
            winnerFlag = true;
        }
    }

    public boolean getWinnerFlag() {
        return winnerFlag;
    }
}
