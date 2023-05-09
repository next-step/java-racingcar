package racingcar.domain.random;

import java.util.Random;

public class RangeRandomNumberGenerator implements RandomNumberGenerator {
    private final int randomMin;
    private final int randomMax;
    private final Random random;

    public RangeRandomNumberGenerator(int randomMin, int randomMax) {
        this.randomMin = randomMin;
        this.randomMax = randomMax;
        this.random = new Random();
    }

    @Override
    public RandNum generate() {
        int range = randomMax - randomMin + 1;

        return new RandNum(this.random.nextInt(range) + randomMin);
    }
}
