package racingcar;

import java.util.Random;

public class RandomGeneratorImpl implements RandomGenerator {
    private int maxRange;

    public RandomGeneratorImpl(int maxRange) {
        this.maxRange = maxRange;
    }

    @Override
    public int getRandomValue() {
        Random random = new Random();
        return random.nextInt(maxRange);
    }
}
