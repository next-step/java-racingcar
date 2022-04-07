package racingcar;

import java.util.Random;

public class RandomNumberGenerator {

    private final Random random = new Random();

    private static final int RANDOM_BOUNDARY = 10;

    public int generateRacingRandomNumber() {
        return random.nextInt(RANDOM_BOUNDARY);
    }
}
