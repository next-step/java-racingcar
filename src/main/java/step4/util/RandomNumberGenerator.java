package step4.util;

import java.util.Random;

public class RandomNumberGenerator {
    private static final Random random = new Random();

    private static final int MINIMUM_REQUIRED_VALUE = 4;
    private static final int MAX_INITIALIZE_VALUE = 10;

    public boolean isGreaterThanThree() {
        return random.nextInt(MAX_INITIALIZE_VALUE) >= MINIMUM_REQUIRED_VALUE;
    }

}
