package step3;

import java.util.Random;

public class RandomUtil {
    private static final int BOUND = 10;

    public static int makeRandomNumber() {
        return new Random().nextInt(BOUND);
    }
}
