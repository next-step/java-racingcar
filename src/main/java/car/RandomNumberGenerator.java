package car;

import java.util.Random;

public class RandomNumberGenerator {
    private static final Random random = new Random();
    private static final Integer RANDOM_NUMBER_BOUND = 10;

    public static Integer makeRandomNumber() {
        return random.nextInt(RANDOM_NUMBER_BOUND);
    }

}
