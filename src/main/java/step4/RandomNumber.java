package step4;

import java.util.Random;

public class RandomNumber {
    private static final int RANDOM_NUMBER_MAX_BOUND = 10;
    private static final int ADVANCE_RANDOM_NUMBER = 4;
    private final Random random = new Random();

    public boolean movable(int randomNum) {
        return randomNum >= ADVANCE_RANDOM_NUMBER;
    }

    public int generateRandomNumber() {
        return random.nextInt(RANDOM_NUMBER_MAX_BOUND);
    }
}
