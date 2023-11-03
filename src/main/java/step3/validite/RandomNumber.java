package step3.validite;

import java.util.Random;

public class RandomNumber {

    private static final int RANDOM_NUMBER_MAX = 10;

    public static int randomNumberCreate() {
        Random random = new Random();
        return random.nextInt(RANDOM_NUMBER_MAX);
    }
}
