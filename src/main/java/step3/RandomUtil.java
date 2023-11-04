package step3;

import java.util.Random;

public class RandomUtil {

    private static final int RANDOM_BOUND = 10;
    private static final Random random = new Random();

    public static int random() {
        return random.nextInt(RANDOM_BOUND);
    }

}
