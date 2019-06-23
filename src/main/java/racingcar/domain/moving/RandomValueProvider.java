package racingcar.domain.moving;

import java.util.Random;

public class RandomValueProvider {

    private final Random random = new Random();
    private final int range;

    public RandomValueProvider(int range) {
        if (range < 0) {
            throw new IllegalArgumentException("invalid random range");
        }
        this.range = range;
    }

    public int get() {
        return random.nextInt(range);
    }
}
