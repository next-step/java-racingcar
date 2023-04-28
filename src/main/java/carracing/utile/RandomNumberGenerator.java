package carracing.utile;

import java.util.Random;

public class RandomNumberGenerator {
    private static final int MAX_BOUND = 10;
    public static final Random random = new Random();

    public static int getRandomNumber() {
        return random.nextInt(MAX_BOUND);
    }
}
