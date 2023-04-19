package racinggame;

import java.util.Random;

public class RandomNumberGenerator {
    private static final int RANDOM_NUMBER_STANDARD = 10;
    private static final Random DEFAULT_RANDOM = new Random();

    public static int randomNumber() {
        return DEFAULT_RANDOM.nextInt(RANDOM_NUMBER_STANDARD);
    }

}
