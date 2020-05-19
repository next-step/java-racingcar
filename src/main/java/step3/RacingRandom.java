package step3;

import java.util.Random;

public class RacingRandom {
    private static final int BOUND_NUMBER = 10;

    private static final Random random = new Random();

    public int getRandomNumber() {
        return random.nextInt(BOUND_NUMBER);
    }
}

