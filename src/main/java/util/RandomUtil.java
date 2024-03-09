package util;

import java.util.Random;

public class RandomUtil {
    private static final int BOUND = 10;

    public int randomNumber() {
        return new Random().nextInt(BOUND);
    }
}
