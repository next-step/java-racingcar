package step4;

import java.util.Random;

public class Util {
    public static final int RANDOM_NUMBER_MAX_BOUND = 10;
    private static final String SEPARATOR = ",";
    private static final Random random = new Random();

    public static String[] separateCarNames(String carNames) {
        return carNames.split(SEPARATOR);
    }

    public static int generateRandomNumber() {
        return random.nextInt(RANDOM_NUMBER_MAX_BOUND);
    }
}
