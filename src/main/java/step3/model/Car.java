package step3.model;

import static step3.model.Race.getRandomValue;

public class Car {

    private static final int MINIMUM_RANDOM_VALUE = 4;
    private static final int START_VALUE = 1;
    private int currentStatus;

    public Car() {
        this.currentStatus = START_VALUE;
    }

    public boolean isMovable(int times) {
        return times >= MINIMUM_RANDOM_VALUE;
    }

    public void go() {
        if (isMovable(getRandomValue())) {
            this.currentStatus++;
        }
    }

    public int getCurrentStatus() {
        return this.currentStatus;
    }
}
