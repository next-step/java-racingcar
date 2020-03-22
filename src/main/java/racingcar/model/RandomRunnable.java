package racingcar.model;

import java.util.Random;

public class RandomRunnable implements Runnable {
    private static final int MINIMUM_NUMBER_TO_RUN = 4;
    private static final int BOUND = 10;

    @Override
    public boolean isRunnable() {
        return new Random().nextInt(BOUND) >= MINIMUM_NUMBER_TO_RUN;
    }
}
