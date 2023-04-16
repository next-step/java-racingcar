package racingcar;

import java.util.Random;


public class RacingRandom {

    public static final int LIMIT = 10;
    private static final Random random = new Random();
    private static final RacingRandom instance = new RacingRandom();

    private RacingRandom() {
    }

    public static RacingRandom getInstance() {
        return instance;
    }

    public int getNumber() {
        return random.nextInt(LIMIT);
    }
}
