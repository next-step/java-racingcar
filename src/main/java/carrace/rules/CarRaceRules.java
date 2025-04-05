package carrace.utils;

import java.util.Random;

public class RandomValue {

    private static final int UPPER_BOUND = 10;

    // random 값을 반환
    public static int generate() {
        Random random = new Random();
        return random.nextInt(UPPER_BOUND);
    }
}
