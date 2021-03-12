package step33;

import java.util.Random;

public class RandomGenerator{

    public static final int RANDOM_RANGE = 10;

    private Random random;

    public RandomGenerator(Random random) {
        this.random = random;
    }

    public int getRandomNumber() {
        return random.nextInt(RANDOM_RANGE);
    }
}
