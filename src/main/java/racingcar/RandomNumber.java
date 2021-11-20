package racingcar;

import java.util.Random;

public class RandomNumber {
    private static final int STANDARD_TO_GO = 4;
    private static final int BOUND_RANDOM_NUMBER = 10;
    private static final Random RANDOM = new Random();
    private final int number;

    public RandomNumber() {
        this.number = RANDOM.nextInt(BOUND_RANDOM_NUMBER);
    }

    public RandomNumber(int number) {
        this.number = number;
    }

    public boolean isMovable() {
        return this.number >= STANDARD_TO_GO;
    }
}
