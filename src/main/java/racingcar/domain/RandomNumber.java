package racingcar.domain;

import java.util.Random;

public class RandomNumber {
    private static final int RANDOM_RANGE = 10;

    private static final int MOVE_THRESHOLD = 4;

    private int number;

    public RandomNumber() {
        Random random = new Random();
        number = random.nextInt(RANDOM_RANGE);
    }

    public RandomNumber(int number) {
        this.number = number;
    }

    public boolean isMovable() {
        return number >= MOVE_THRESHOLD;
    }
}
