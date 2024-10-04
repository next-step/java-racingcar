package racinggame.domain;

import java.util.Random;

public class RandomNumber {
    private static final int DEFAULT_BOUND = 10;

    private final int value;
    private final Random random = new Random();

    public RandomNumber() {
        this.value = random.nextInt(DEFAULT_BOUND);
    }

    public int getValue() {
        return value;
    }
}
