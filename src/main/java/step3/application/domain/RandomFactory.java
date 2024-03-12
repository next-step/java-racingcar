package step3.application.domain;

import java.util.Random;

public class RandomFactory {

    private final Random random;
    public static final int MAX_BOUND = 10;

    public RandomFactory() {
        this.random = new Random();
    }

    public int drawNumber() {
        return random.nextInt(MAX_BOUND);
    }
}
