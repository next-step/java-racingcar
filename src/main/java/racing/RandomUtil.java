package racing;

import java.util.Random;

public class RandomUtil {

    public static final int BOUND = 10;

    private static final Random random = new Random();

    public static int randomNumberZeroToNine() {
        return random.nextInt(BOUND);
    }
}
