package step3;

import java.util.Random;

public class RacingRandom {
    private static final int BOUND_NUMBER = 4;

    private Random random;

    public RacingRandom() {
        random = new Random();
    }

    public int getRandomNumber() {
        return random.nextInt(BOUND_NUMBER);
    }
}

