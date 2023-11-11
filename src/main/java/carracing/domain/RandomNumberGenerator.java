package carracing;

import java.util.Random;

public class RandomNumberGenerator {

    private static final int MAX_RANDOM_BOUND = 10;
    private static final Random random = new Random();

    public int getRandomNumber() {
        return random.nextInt(MAX_RANDOM_BOUND);
    }

}
