package racing_game.domain;

import java.util.Random;

public class RandomGenerator {

    private final Random random;

    private RandomGenerator() {
        this.random = new Random();
    }

    public static RandomGenerator create() {
        return new RandomGenerator();
    }

    public int getRandomValue() {
        return random.nextInt(10);
    }
}
