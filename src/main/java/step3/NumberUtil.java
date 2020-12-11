package step3;

import java.util.Random;

public class NumberUtil {
    private static final Random random = new Random();
    public static final int BOUND = 10;

    public static int generateRandomIntZeroToTen() {
        return random.nextInt(BOUND);
    }

}
