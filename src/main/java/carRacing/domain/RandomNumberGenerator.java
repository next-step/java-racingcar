package carRacing.domain;

import java.util.Random;

public class RandomNumberGenerator {
    public static final Random random = new Random();

    public static int getRandomNumber() {
        return random.nextInt(10);
    }
}
