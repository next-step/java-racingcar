package race.util;

import java.util.Random;

public class RandomNumberUtil {

    private static final Random RANDOM = new Random();
    private static final int BOUND = 10;

    public static int randomNumber() {
        return RANDOM.nextInt(BOUND);
    }
}
