package racing.utils;

import java.util.Random;

public class RandomNumber {

    private static final int RANDOM_NUMBER_RANGE = 10;
    private final Random random;

    public RandomNumber() {
        random = new Random();
    }

    public int create() {
        return this.random.nextInt(RANDOM_NUMBER_RANGE);
    }
}
