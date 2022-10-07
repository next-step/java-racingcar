package racingcar.strategy;

import java.util.Random;

public class RandomNumberGenerateStrategy implements NumberGenerateStrategy {

    private final Random random = new Random();

    private int bound;

    private RandomNumberGenerateStrategy() {}

    public RandomNumberGenerateStrategy(int bound) {
        this.bound = bound;
    }

    @Override
    public int generate() {
        return random.nextInt(bound);
    }
}
