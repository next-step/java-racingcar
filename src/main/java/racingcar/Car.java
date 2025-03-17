package racingcar;

import java.util.Random;

public class Car {

    private static final int RANDOM_NUMBER_THRESHOLD = 10;
    private static final int MOVE_THRESHOLD = 4;

    private int position;

    public Car() {
        this.position = 0;
    }

    public int getPosition() {
        return this.position;
    }

    public void move(Random random) {
        if (this.isAboveMoveThreshold(random)) {
            this.position++;
        }
    }

    private boolean isAboveMoveThreshold(Random random) {
        return this.getRandomNumber(random) >= Car.MOVE_THRESHOLD;
    }

    private int getRandomNumber(Random random) {
        return random.nextInt(Car.RANDOM_NUMBER_THRESHOLD);
    }
}