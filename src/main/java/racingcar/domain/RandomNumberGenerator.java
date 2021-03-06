package racingcar.domain;

import java.util.Random;

public class RandomNumberGenerator implements NumberGenerator {

    private int maxValue;

    private int minValue;

    public RandomNumberGenerator(int maxValue, int minValue) {
        this.maxValue = maxValue;
        this.minValue = minValue;
    }

    @Override
    public int generate() {
        return new Random().nextInt(maxValue + 1 - minValue) + minValue;
    }
}
