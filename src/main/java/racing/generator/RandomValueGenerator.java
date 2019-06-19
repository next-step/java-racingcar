package racing.generator;

import java.util.Random;

public class RandomValueGenerator implements ValueGenerator {

    private final Random random;
    private final int bound;

    public RandomValueGenerator(int bound) {

        this.random = new Random();
        this.bound = bound;
    }

    @Override
    public int generateIntValue() {

        return random.nextInt(bound);
    }
}
