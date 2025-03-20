package step4.racingCar.util;

import java.util.Random;


public class NumberRandomUtil {

    private static final Random random = new Random();
    private static final int BOUND = 10;

    public static int generate() {
        return random.nextInt(BOUND);
    }
}
