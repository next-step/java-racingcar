package racingcar.domain.random;

import java.util.Random;

public class RandomGenerator {
    private final int randomMin;
    private final int randomMax;

    public RandomGenerator(int randomMin, int randomMax) {
        this.randomMin = randomMin;
        this.randomMax = randomMax;
    }

    public RandNum generate() {
        Random random = new Random();

        int range = randomMax - randomMin + 1;

        return new RandNum(random.nextInt(range) + randomMin);
    }
}
