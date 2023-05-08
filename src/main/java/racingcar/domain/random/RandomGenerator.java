package racingcar.domain.random;

import java.util.Random;

public class RandomGenerator {
    private final int randomMin;
    private final int randomMax;
    private final Random random;

    public RandomGenerator(int randomMin, int randomMax) {
        this.randomMin = randomMin;
        this.randomMax = randomMax;
        this.random = new Random();
    }

    public RandNum generate() {
        int range = randomMax - randomMin + 1;

        return new RandNum(this.random.nextInt(range) + randomMin);
    }
}
