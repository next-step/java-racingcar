package step3;

import java.util.Random;

public class RandomEngine implements CarEngine {
    private static final Random random = new Random();
    private static final int RANDOM_BOUND = 10;

    public int getPower() {
        return random.nextInt(RANDOM_BOUND);
    }
}
