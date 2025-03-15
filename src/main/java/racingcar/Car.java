package racingcar;

import java.util.Random;

public class Car {
    private static final int RANDOM_NUMBER_BOUND = 10;
    private static final int MOVE_BOUND = 4;
    private final Random random;
    private int position;

    public Car(Random random) {
        this.random = random;
        this.position = 0;
    }

    public int getPosition() {
        return this.position;
    }

    public void move() {
        if (isMove()) {
            this.position++;
        }
    }

    @VisibleForTesting
    boolean isMove() {
        return this.getRandomNumber() >= Car.MOVE_BOUND;
    }

    private int getRandomNumber() {
        return random.nextInt(Car.RANDOM_NUMBER_BOUND);
    }
}
