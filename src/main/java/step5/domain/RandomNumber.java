package step5.domain;

import java.util.Random;

public class RandomNumber {

    private static final int RANDOM_NUMBER_RANGE = 10;
    private static final Random random = new Random();

    public static int getRandomNumber() {
        return random.nextInt(RANDOM_NUMBER_RANGE);
    }
}
