package racingcar.utils;

import java.util.Random;

public class NumberUtil {

    private NumberUtil() { }

    public static int generateRandomNumber() {
        Random random = new Random();
        return random.nextInt(10);
    }

    public static boolean isPossibleToMove(int number) {
        return number >= 4;
    }
}
