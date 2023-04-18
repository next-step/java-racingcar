package step3.utils;

import java.util.Random;

public class RacingUtils {
    private static final int NUMBER_LIMIT = 4;

    public static boolean isOverLimit(int number) {
        return number >= NUMBER_LIMIT;
    }

    public static int generateRandomNumber(int bound) {
        Random random = new Random();
        int randomNumber = random.nextInt(bound);

        return randomNumber;
    }

}
