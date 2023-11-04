package step3.validite;

import java.util.Random;

public class RandomNumber {

    private static final int RANDOM_NUMBER_MAX = 10;
    private static final Random RANDOM = new Random();

    public static int randomNumberCreate() {
        return RANDOM.nextInt(RANDOM_NUMBER_MAX);
    }
}
