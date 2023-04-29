package racingcar;

import java.util.Random;

public class RandomNumberGenerator {

    private static final int THRESHOLD = 4;
    private static final int SIX = 6;
    private static final int LIMIT = 10;
    private static final Random RANDOM = new Random();

    public int generateNumber() {
        return RANDOM.nextInt(LIMIT);
    }

    public int generateNumberAboveFour() {
        return RANDOM.nextInt(SIX) + THRESHOLD;
    }
}
