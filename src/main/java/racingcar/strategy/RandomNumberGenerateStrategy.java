package racingcar.strategy;

import java.util.Random;

public class RandomNumberGenerateStrategy implements NumberGenerateStrategy {

    private final Random random = new Random();
    private final int DEFAULT_BOUND = 10;

    private int bound;

    public RandomNumberGenerateStrategy() {
        this.bound = DEFAULT_BOUND;
    }

    @Override
    public int generate() {
        return random.nextInt(bound);
    }
}
