package racingcar.util;

import java.util.Random;

public class RandomNumberGenerator implements NumberGenerator{

    private Random random;
    private int max;

    public RandomNumberGenerator(int max) {
        this.random = new Random();
        this.max = max;
    }

    @Override
    public int get() {
        return random.nextInt(max);
    }
}