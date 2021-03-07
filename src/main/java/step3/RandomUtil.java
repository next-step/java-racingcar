package step3;

import java.util.Random;

public class RandomUtil {

    public static final int BOUND10 = 10;
    private static final Random random = new Random();

    public static int nextInt(int bound) {
        return random.nextInt(bound);
    }
}
