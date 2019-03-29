package car.domain;

import java.util.Random;

public class RandomNumber {
    private static final int MAX_NUMBER_BOUND = 10;

    public static int getNumber() {
        Random random = new Random();
        return random.nextInt(MAX_NUMBER_BOUND);
    }
}
