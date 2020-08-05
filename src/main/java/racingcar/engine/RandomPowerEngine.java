package racingcar.engine;

import java.util.Random;

public class RandomPowerEngine implements PowerEngine {
    private static int POWER_BOUND = 10;
    private static int MINIMUM_POWER = 4;
    private Random random;

    public RandomPowerEngine() {
        this.random = new Random();
    }

    @Override
    public int go() {
        return random.nextInt(POWER_BOUND) < MINIMUM_POWER ? 0 : 1;
    }
}
