package racinggame.util;

import java.util.Random;

public class RandomNumber {

    private static final int RANDOM_NUMBER_RANGE = 10;
    private final Random random;

    public RandomNumber() {
        random = new Random();
    }

    public int createBetweenZeroToNine() {
        return this.random.nextInt(RANDOM_NUMBER_RANGE);
    }
}
