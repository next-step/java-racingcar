package step3.application.generator;

import java.util.Random;

public class NumberRandomGenerator implements NumberGenerator{

    private final Random random;
    public static final int MAX_BOUND = 10;

    public NumberRandomGenerator() {
        this.random = new Random();
    }

    public int drawNumber() {
        return random.nextInt(MAX_BOUND);
    }
}
