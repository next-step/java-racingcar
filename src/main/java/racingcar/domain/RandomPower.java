package racingcar.domain;

import java.util.Random;

public class RandomPower {

    private static final Random random = new Random();
    private static final int RANDOM_RANGE = 10;

    private static RandomPower randomPower = new RandomPower();

    private RandomPower() {}

    public static RandomPower getInstance() {
        return randomPower;
    }

    public int nextInt() {
        return random.nextInt(RANDOM_RANGE);
    }
}
