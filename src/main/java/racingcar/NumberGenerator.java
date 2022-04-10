package racingcar;

import java.util.Random;

public class NumberGenerator {

    public static final int RANDOM_NEXT_INT_BOUND = 10;
    private final Random random;

    public NumberGenerator() {
        this.random = new Random();
    }

    public int generateRandomNumber() {
        return random.nextInt(RANDOM_NEXT_INT_BOUND);
    }
}
