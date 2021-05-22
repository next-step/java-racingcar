package carracing;

import java.util.Random;

public class RandomNumber {
    private static final int RANDOM_RANGE = 10;

    public static int createRandomNumber() {
        Random random = new Random();
        return random.nextInt(RANDOM_RANGE);
    }
}
