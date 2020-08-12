package step3.utility;

import java.util.Random;

public class ReturnValue {
    private static final int RANDOM_MAX_VALUE = 10;
    private static Random random = new Random();

    public static int returnValue() {
        return random.nextInt(RANDOM_MAX_VALUE);
    }
}
