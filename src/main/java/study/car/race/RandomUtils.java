package study.car.race;

import java.util.Random;

public class RandomUtils {

    private static final Random random = new Random();

    private RandomUtils() {
    }

    public static int nextInt() {
        return random.nextInt();
    }
}
