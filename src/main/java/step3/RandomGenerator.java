package step3;

import java.util.Random;

public class RandomGenerator {

    private final Random random;
    public RandomGenerator() {
        random = new Random();
    }

    public int getValue() {
        return random.nextInt(10);
    }
}
