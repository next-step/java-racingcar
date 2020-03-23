package racingcar.random;

import java.util.Random;

public class RandomRunnable implements Runnable {
    private static final int MINIMUM_NUMBER_TO_RUN = 4;
    private static final int BOUND = 10;
    private static final Random random = new Random();

    @Override
    public boolean isRunnable() {
        return random.nextInt(BOUND) >= MINIMUM_NUMBER_TO_RUN;
    }
}