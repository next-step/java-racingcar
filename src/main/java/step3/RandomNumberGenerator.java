package step3;

import java.util.Random;

public class RandomNumberGenerator implements NumberGenerator {

    private static final int MAX = 10;

    private final Random random;

    public RandomNumberGenerator() {
        this.random = new Random();
    }

    @Override
    public int generateNumber() {
        return random.nextInt(MAX);
    }
}
