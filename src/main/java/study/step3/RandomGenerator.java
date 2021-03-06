package study.step3;

import java.util.Random;

public class RandomGenerator {

    private static final int RANDOM_NUMBER_RANGE = 10;
    private final Random random = new Random();

    public int getRandomNumber() {
        return random.nextInt(RANDOM_NUMBER_RANGE);
    }
}
