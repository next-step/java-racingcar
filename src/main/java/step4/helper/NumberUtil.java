package step4.helper;

import java.util.Random;

public class NumberUtil {

    private static final Random random = new Random();

    private NumberUtil() {}

    public static int createRandomNumber(int bound) {
        return random.nextInt(bound) + 1;
    }
}
