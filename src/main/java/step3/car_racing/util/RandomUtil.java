package step3.car_racing.util;

import java.util.Random;

public class RandomUtil implements MovingStrategy {

    private static final Integer RANDOM_RANGE = 10;
    private static final Integer STANDARD_VALUE = 4;
    private static final Random random = new Random();

    @Override
    public boolean movable() {
        return isForward();
    }

    public Boolean isForward() {
        return random.nextInt(RANDOM_RANGE) > STANDARD_VALUE;
    }
}
