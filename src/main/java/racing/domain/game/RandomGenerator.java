package racing.domain.game;

import java.util.Random;

public class RandomGenerator {
    private static final int MIN_BOUND = 0;
    private static final int MAX_BOUND = 9;

    private static Random random = new Random();

    public int getRandomNumber() {
        return random.nextInt((MAX_BOUND - MIN_BOUND) + 1) + MIN_BOUND;
    }

}
